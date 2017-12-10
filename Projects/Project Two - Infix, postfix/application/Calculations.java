package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculations {
	
	static File file = new File("equations.txt");
	static String workString="";
	static int MAX;
	static ArrayList<String> infixL = new ArrayList<>(MAX);//infix arrayList
	static ArrayList<String> postL = new ArrayList<>(MAX);//postFix arrayList
	static ArrayList<String> resultL = new ArrayList<>(MAX);//result arrayList

	private Stack stack;
	
	public static void load(File file) throws FileNotFoundException{//to read from the file
		
		Scanner input=new Scanner(file);
		String s;
		int count;
		
		while(input.hasNextLine()){
			workString=input.nextLine();
			infixL.add(workString);
		}
			
		for(count=0;count < infixL.size();){
	
		workString=infixL.get(count);
		String[] length = workString.split("");
		MAX=infixL.get(0).length()*2;
		if(length.length>MAX)
			MAX=length.length;
//		s=splitting(s);
		
		if(workString.startsWith("+ ")){
			workString = workString.replace("+ ", "0 + ");
			if(!isValid(workString)){//if the equation not valid
				postL.add(" - ");
				resultL.add(" - ");
			}
			else{
				s=calculatePostFix(workString);
				postL.add(s);
				s=postL.get(count);
				s=calculateResult(s);
				if(s.equals("ERROR!")){
					resultL.add("Error, Division by Zero!");
				}
				else
				resultL.add(calculateResult(s));
				}
			
				count++;
			}

		else if(workString.startsWith("-")){
			workString = workString.replace("- ", "0 - ");
			
			if(!isValid(workString)){//if the equation not valid
				postL.add(" - ");
				resultL.add(" - ");
			}
			else{
				s=calculatePostFix(workString);
				postL.add(s);
				s=postL.get(count);
				s=calculateResult(s);
				if(s.equals("ERROR!")){
					resultL.add("Error, Division by Zero!");
				}
				else
				resultL.add(calculateResult(s));
				}
				count++;
			}
		else{
			if(!isValid(workString)){//if the equation not valid
				postL.add(" - ");
				resultL.add(" - ");
			}
			else{
				s=calculatePostFix(workString);
				postL.add(s);
				s=postL.get(count);
				s=calculateResult(s);
				if(s.equals("ERROR!")){
					resultL.add("Error, Division by Zero!");
				}
				else
				resultL.add(calculateResult(s));
				}
				count++;
			}
		}
		
	}
	
//	public static String splitting(String s) {
//		
//		StringBuilder sb = new StringBuilder();
//		String[] digits = s.split("");
//		int count;
//		for(count=0;count<digits.length;count++){
//			if(digits[count].equals("")||digits[count].equals(" "))
//				continue;
//			sb.append(digits[count]+" ");
//			}
//		String ss =sb.toString();
//		ss.trim();
//		return ss;
//		
//	/*	String x;
//		
//		x=s.replaceAll(""," ");
//		x=s.trim();
//		return x;*/
//	}

	public static void write(String s) throws FileNotFoundException{
		//to read from user
		workString=s;
		infixL.add(workString);
		
		if(!isValid(workString)){
			postL.add(" - ");
			resultL.add(" - ");
		}
		else{
			s=calculatePostFix(workString);
			postL.add(s);
			s=calculateResult(s);
			resultL.add(calculateResult(s));
			}
		}
	
	public static boolean isValid(String s){

		if(!SecondaryStages.isnumbers(s))
			return false;
		if(s.startsWith("*")||s.startsWith("/")||s.startsWith("%"))
			return false;
		if(s.endsWith("+")||s.endsWith("-")||s.endsWith("*")||s.endsWith("/")||s.endsWith("%"))
			return false;//end with operation
		
		
		String[] digits;//number of ( and )
		int count=0;
		int counter1=0;
		int counter2=0;
		digits=s.split(" ");
		while(count<digits.length){
			if(digits[count].equals("("))
				counter1++;
			else if(digits[count].equals(")"))
					counter2++;
			count++;
		}
		if(counter1 != counter2)
			return false;
		
		count=0;// if it has repeated operations
		int postcount=count+1;
		while(count < digits.length){
			if(digits[count].equals("/")&&digits[postcount].equals("0"))
				return false;
			if(digits[count].equals(" ")&& digits[postcount].equals("("))
				return false;
			if(isOperation(digits[count]) &&  postcount<digits.length-1 && isOperation(digits[postcount])){
				if(isRepeated((String)digits[count],(String)digits[postcount]))
					return false;
			}
				count++;
				postcount++;
			}

		
		return true;
		}
	

	public static String calculatePostFix(String x){//to calculate postfix
		
		Stack stack = new Stack(100);//stack to apply our work
		StringBuilder sb=new StringBuilder();//StringBuilder for the final result
		String digits[]=x.split(" ");
		int count;	

		for(count=0;count<digits.length;count++){
			if(!isOperation(digits[count].trim()))//if !operation
				sb.append(digits[count]+" ");//add to StringBuilder
			else{			
				if(digits[count].contains("("))//else ( case
					stack.push(digits[count]);//push to stack
				else if(digits[count].contains(")")){// ) case
					
					while(!((String)(stack.top())).contains("(")){
						sb.append((String)(stack.top()+" "));
						stack.pop();//to pop all the operations between ( )
					}
					stack.pop();
					continue;
				}
				
				else if(stack.isEmpty())
					stack.push(digits[count]);
				
				else if(priority(digits[count], (String)stack.top()))
					stack.push(digits[count]);
				
				else{
					while(!stack.isEmpty()&&priority((String)stack.top(),digits[count] )){
						sb.append(((String)stack.top()).trim()+" ");
						stack.pop();
					}
					stack.push(digits[count]);
				}
			}
		}	
		while(!stack.isEmpty()){//to pop the stack if it's not empty after ending the work
			sb.append(((String)stack.top()).trim()+" ");
			stack.pop();
		}
		return sb.toString();
	}
	
	public static String calculateResult(String s) {//to calculate result
		
		Stack stack = new Stack(100);
		int count = 0;
		float num1, num2;
		String[] digits = s.split(" ");
		while (count < digits.length) {
			
			if (!isPremitiveAthmeitc(digits[count].trim()))
				stack.push(digits[count]);
			else {
				num2 = Float.parseFloat((String) stack.top());
				stack.pop();
				num1 = Float.parseFloat((String) stack.top());
				stack.pop();
				if(digits[count].equals("/")&& num2==0){
					return "ERROR!";
				}
				else
				stack.push("" +calculate(num1, digits[count].trim().charAt(0), num2));
				}
			count++;
		}
		String res =(String) stack.top();
		stack.pop();
		return res;
	}
	
	public static void report() throws FileNotFoundException{
		//to report on the file
		File file = new File("report.txt");
		PrintWriter output = new PrintWriter(file);
		file=null;
		int count=0;
		while(count<infixL.size()){
			output.print(infixL.get(count)+"\t\t");
			output.print(isValid(infixL.get(count)));
			output.print("\t\t"+postL.get(count));
			output.print("\t\t"+resultL.get(count));
			output.println();
			count++;
		}
		output.close();
	}
	
	public static boolean priority(String x,String y){//for calculate postfix
		
		 if(x.contains("+")&&y.contains("+") || x.contains("-")&&y.contains("-")||x.contains("*")&&y.contains("*")||x.contains("/")&&y.contains("/"))
			return true;
		else if(x.contains("-")&&y.contains("+"))
			return true;
		else if(x.contains("*")&&y.contains("/")||x.contains("/")&&y.contains("*")||x.contains("*")&&y.contains("+")||x.contains("*")&&y.contains("-"))
			return true;
		else if(x.contains("/")&&y.contains("+")||x.contains("/")&&y.contains("-"))
			return true;
		
	return false;
	}
	
	
	public Calculations(int size) {//constructor
		stack=new Stack(size);
	}
	
	private static  boolean isOperation(String s){//to check if operation or not
		s.trim();//and for validity
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("%")
				||s.equals("(")||s.equals(")"))
			return true;
		return false;
		}
	
	private static float calculate(float n1,char op, float n2){
		// to calculate the equation for the result
		switch(op){
		case '+':
			return n1+n2;
		case '-':
			return n1-n2;
		case '*':
			return n1*n2;
		case '/':
			return n1/n2;			
		case '%':
			return n1%n2;		
		default:
			return 0;		
		}
	}	
	
	public static boolean isRepeated(String x,String y){
		if(x.equals("+") && y.equals("+")||x.equals("+") && y.equals("*")||x.equals("+") && y.equals("/")||x.equals("+") && y.equals("%")
				||x.equals("-") && y.equals("+")||x.equals("-") && y.equals("*")||x.equals("-") && y.equals("/")||x.equals("-") && y.equals("%")
				||x.equals("*") && y.equals("+")||x.equals("*") && y.equals("*")||x.equals("*") && y.equals("/")||x.equals("*") && y.equals("%")
				||x.equals("/") && y.equals("+")||x.equals("/") && y.equals("*")||x.equals("/") && y.equals("/")||x.equals("/") && y.equals("%")
				||x.equals("(") && y.equals("+")||x.equals("(") && y.equals("*")||x.equals("(") && y.equals("/")||x.equals("(") && y.equals("%")
				||x.equals("+") && y.equals(")")||x.equals("-") && y.equals(")")||x.equals("*") && y.equals(")")||x.equals("/") && y.equals(")")||x.equals("%") && y.equals(")")
				||x.equals("(") && y.equals(")")||x.equals(")") && y.equals("(")||x.equals(" ") && y.equals("("))
			return true;
		
		else if(x.equals("+") && y.equals("-")||x.equals("*") && y.equals("-")
				||x.equals("/") && y.equals("-")||x.equals("(") && y.equals("-")){
			workString = workString.replace("- ", "0 - ");
			return false;
		}
		else if (x.equals("-") && y.equals("-")){
			workString = workString.replace("- - ", "+ ");
			return false;
		}
/*		else if(x.equals("(") && y.equals(")")){
			workString=workString.replace("( ) ", "( 0 ) "); 
		}*/
			
		return false;
	}
	private static  boolean isPremitiveAthmeitc(String s){//to check if operation or not
		s.trim();//and for validity
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("%"))
			return true;
		return false;
		
	}
	/*	public static boolean isValid(String s) {
	try {
		java.util.regex.Pattern.compile(s);
		return true;
	} catch (java.util.regex.PatternSyntaxException e) {
		return false;
	}
}*/
}
