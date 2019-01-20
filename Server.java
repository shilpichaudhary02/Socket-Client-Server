import java.net.*;  
import java.io.*;  
class Server
{  
	public static void main(String args[])throws Exception
	{  
		ServerSocket ss = new ServerSocket(5353);  
		Socket s = ss.accept();  
		DataInputStream input = new DataInputStream(s.getInputStream());  
		DataOutputStream output = new DataOutputStream(s.getOutputStream());  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
  
		String a="", b="";  
		while(!a.equals("stop"))	
		{  
			a=input.readUTF();  
			System.out.println("client : "+a);  
			b=br.readLine();  
			output.writeUTF(b);  
			output.flush();  
		}  
		input.close();  
		s.close();  
		ss.close();  
	}
}  
