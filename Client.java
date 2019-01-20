import java.net.*;  
import java.io.*;  
class Client
{  
	public static void main(String args[])throws Exception
	{  
		Socket s = new Socket("192.168.1.8",5353);  
		DataInputStream input = new DataInputStream(s.getInputStream());  
		DataOutputStream output = new DataOutputStream(s.getOutputStream());  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
  
		String a="",b="";  
		while(!a.equals("stop"))
		{  
			a=br.readLine();  
			output.writeUTF(a);  
			output.flush();  
			b=input.readUTF();  
			System.out.println("Server : "+b);  
		}  
  
		output.close();  
		s.close();  
	}
}  
