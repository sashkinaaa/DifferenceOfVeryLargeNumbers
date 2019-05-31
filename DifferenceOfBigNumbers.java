
public class DifferenceOfBigNumbers {
	
	// Returns true if str1 is smaller than str2. 
	static boolean isSmaller(String str1, String str2) 
	{ 
	    // Calculate lengths of both string 
	    int n1 = str1.length(), n2 = str2.length(); 
	    if (n1 < n2) 
	        return true; 
	    if (n2 < n1) 
	        return false; 
	      
	    for (int i = 0; i < n1; i++) 
	    if (str1.charAt(i) < str2.charAt(i)) 
	        return true; 
	    else if (str1.charAt(i) > str2.charAt(i)) 
	        return false; 
	  
	    return false; 
	} 
	
	
	public static String reverseString(String str) {
		String reverseStr = "";
		for(int i = str.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + str.charAt(i);
        }
		return reverseStr;
	}
	
	public static String cutZeors(String str) {
		boolean isZeroAtEnd = true;
		int numOfZeors = 0;
		for(int i = str.length() - 1; i >= 0; i--) {
			if(isZeroAtEnd && (int)(str.charAt(i)-'0') == 0) {
				numOfZeors++;
			}
			else {
				isZeroAtEnd = false;
				break;
			}
		}
		return str.substring(0, str.length() - numOfZeors);
	}
	
	// Function for find difference of larger numbers 
	static String findDiff(String str1, String str2) 
	{ 
	    // Before proceeding further, make sure str1 
	    // is not smaller 
	    if (isSmaller(str1, str2)) 
	    { 
	        String t = str1; 
	        str1 = str2; 
	        str2 = t; 
	    } 
	  
	    // Take an empty string for storing result 
	    String str = ""; 
	  
	    // Calculate length of both string 
	    int n1 = str1.length(), n2 = str2.length(); 
	  
	    // Reverse both of strings 
	    //str1 = new StringBuilder(str1).reverse().toString(); 
	    //str2 = new StringBuilder(str2).reverse().toString(); 
	    str1 = reverseString(str1);
	    str2 = reverseString(str2);
	      
	    int carry = 0; 
	  
	    // Run loop till small string length 
	    // and subtract digit of str1 to str2 
	    for (int i = 0; i < n2; i++) 
	    { 
	        // Do school mathematics, compute difference of 
	        // current digits 
	        int sub = ((int)(str1.charAt(i)-'0') -  
	                   (int)(str2.charAt(i)-'0')-carry); 
	          
	        // If subtraction is less then zero 
	        // we add then we add 10 into sub and 
	        // take carry as 1 for calculating next step 
	        if (sub < 0) 
	        { 
	            sub = sub + 10; 
	            carry = 1; 
	        } 
	        else
	            carry = 0; 
	  
	        str += (char)(sub + '0'); 
	    } 
	  
	    // subtract remaining digits of larger number 
	    for (int i = n2; i < n1; i++) 
	    { 
	        int sub = ((int)(str1.charAt(i) - '0') - carry); 
	          
	        // if the sub value is -ve, then make it positive 
	        if (sub < 0) 
	        { 
	            sub = sub + 10; 
	            carry = 1; 
	        } 
	        else
	            carry = 0; 
	              
	        str += (char)(sub + '0'); 
	    } 
	    
	    str = cutZeors(str);
	    // reverse resultant string 
	    //return new StringBuilder(str).reverse().toString(); 
	    return str = reverseString(str);
	} 
	  
	// Driver code 
	public static void main(String[] args) 
	{ 
	    String str1 = "25"; 
	    String str2 = "255"; 
	    System.out.println(findDiff(str1, str2)); 
	  
	    String s1 = "100"; 
	    String s2 = "1000000"; 
	    System.out.println(findDiff(s1,s2)); 
	} 
}
