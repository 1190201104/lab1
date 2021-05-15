package P1;
import java.io.*;
import java.util.Scanner;

public class MagicSquare {
	public static boolean generateMagicSquare(int n) {
		if(n<0 || n%2==0)
		{
			System.out.print("���벻����Ҫ��������������");
			return false;
		}
		int magic[][] = new int[n][n];//���������������������
		String magout[][]=new String[n][n];
		int row = 0, col = n / 2, i, j, square = n * n;
		for (i = 1; i <= square; i++) //�ӵ�һ���м俪ʼ��
		{
			magic[row][col] = i;//���������ż������������±�Խ��
			magout[row][col]=Integer.toString(i);
			if (i % n == 0)//����Ѿ�����n����
				row++;//ת����һ��
			else 
			{
				if (row == 0)//����ǵ�һ����ת�����һ��
					row = n - 1;
				else
					row--;//�����Ǿ�ת����һ��
				if (col == (n - 1))
					col = 0;//��������һ���ˣ�ת����һ��
				else
					col++;//�����Ǿ�ת����һ��
			} 
		}
		for (i = 0; i < n; i++) 
		{
			for (j = 0; j < n; j++)
				System.out.print(magic[i][j] + "\t");
		System.out.println();
		}
		try {
			OutputStreamWriter fout = null;//����һ���� ��
			fout = new OutputStreamWriter(new FileOutputStream("D:\\JAVA\\sourse\\Lab1-1190201104\\src\\P1\\txt\\6.txt"),"GBK");
//			FileOutputStream fout = new FileOutputStream("D:\\JAVA\\sourse\\Lab1-1190201104\\src\\txt\\txt.6");
//			OutputStreamWriter writer = new OutputStreamWriter(fout);
			for (i = 0; i < n; i++) 
			{
				for (j = 0; j < n; j++)
					{
					fout.write(magout[i][j]);
					fout.write("\t");
					}
				fout.write("\n");
			}
			fout.close();
		} catch (Exception e) {		
			e.printStackTrace();
		} 
		return true;
		}
	public static boolean isLegalMagicSquare(String fileName)
	{
		boolean ret=true;
		String []s=new String [150];
		   int i=0;
		   int j=0;
		   try//���ж����ַ�����s�д�ŵ���ÿһ�е�����
		    {
		    	FileInputStream fin=new FileInputStream("D:\\JAVA\\sourse\\Lab1-1190201104\\src\\P1\\txt\\"+fileName);
		    	InputStreamReader reader = new InputStreamReader(fin);
		    	BufferedReader buffReader = new BufferedReader(reader);		    	
		    	String strtmp;
		    	while((strtmp = buffReader.readLine())!=null)
		    	{
	        	 s[i]=strtmp;
	        	 i++;	 
		    	}
		    	buffReader.close();//�ر�
		    }catch (Exception e) {
		    	e.printStackTrace();
			} 
		 
		    int length=i;//length��¼����
		    //��width��¼ÿһ�е����ָ���
		    int width0[]=new int[length];
		    for(i=0;i<length;i++)
		    {   
			  width0[i]=(s[i].split("\t")).length;
			  if(length != width0[i] )
			  {   
				  if(i>0)//����ʼ����������ȣ����治��ȣ��ǿ϶����Ǿ���
					  System.out.print("���Ǿ���");
				  else if(i==0 && width0[0]==s[1].split("\t").length)
					  System.out.print("�����������");//���һ��ʼ�Ͳ�����ǾͲ���������
				  ret=false;
				  return ret;
			  }
			  
		    }
		    int width=width0[0];//������е������ǿ϶��������������	
		    
		    String [][]ss= new String[length][width];
		    int [][]num = new int[length][width];
		    for(i=0;s[i]!=null;i++) 
		    {
			  ss[i]=s[i].split("\t");//�ö�ά�ַ��������¼����
		    }		  		  
		    for(i=0;i<length;i++)
		    {   for(j=0;j<width;j++)
	      		{  
		    	   if(ss[i][j].contains(" ")==true)
		    	   { 
		    		 System.out.print("���ڿո�");
		    	   	 ret=false;
					 return ret;  
		    	   }
		    	   else if(ss[i][j].contains(".")==true)
		    	   {
		    		   System.out.print("���ڷ�int������");
			    	   ret=false;
					   return ret; 
		    	   }		    		   
	    	       num[i][j]=Integer.valueOf(ss[i][j]);//���ַ���ת��Ϊ����
	    	       if(num[i][j]<0)
	    	       {   
	    	    	   System.out.print("���ڸ���");
	    	    	   ret=false;
	 				   return ret;
	    	       }
	      		}
		    }
		    int sum=0;//sum����ǵ�һ�е�ֵ�ĺ�
		    int sum0=0;//sum0�ô�ÿһ�л��е�ֵ�ĺ�
		    int sum1=0;
		    //�ó���һ�е�ֵ�ĺ�
		    for(j=0;j<length;j++)
	      	{
	    	  sum+=num[0][j];        
	      	}
		    //�����бȽ�
		    for(i=0;i<length;i++)
		    {   
		      sum0=0;
	          sum1=0;
	    	  for(j=0;j<length;j++)
	    	  {
	    		  sum0+=num[i][j];
	    		  sum1+=num[j][i];
	    	  }
	    	  if(sum0!=sum && sum1!=sum)
	    	  {
	    		  ret=false;
	    		  System.out.print("�Ͳ�����");
	    		  break;
	    	  }
		    }
		    //�ԽǱȽ�
		    sum1=0;
		    sum0=0;
		    for(i=0;i<length;i++)
		    {    
	    	  sum0+=num[i][i];
	    	  sum1+=num[i][length-i-1];
		    }
		    if(sum0!=sum && sum1 !=sum)
		    {   
	    	  System.out.print("�Ͳ�����");
	    	  ret=false;
		    }	      
		    return ret;
	}
	public static void main(String[] args)   {
		String txt[]= {"1.txt","2.txt","3.txt","4.txt","5.txt",};
		int num=txt.length;
		int n;
		boolean equal;//�����ִ��������У����������ж�
		for(int i=0;i<num;i++)
		{
			System.out.print("��"+(i+1)+"������");
		    equal=isLegalMagicSquare(txt[i]);
			System.out.println(equal);
		}
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		generateMagicSquare(n);
	   }    
}

	


