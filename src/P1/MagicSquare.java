package P1;
import java.io.*;
import java.util.Scanner;

public class MagicSquare {
	public static boolean generateMagicSquare(int n) {
		if(n<0 || n%2==0)
		{
			System.out.print("输入不符合要求，请输入正奇数");
			return false;
		}
		int magic[][] = new int[n][n];//根据输入的数字生成数组
		String magout[][]=new String[n][n];
		int row = 0, col = n / 2, i, j, square = n * n;
		for (i = 1; i <= square; i++) //从第一行中间开始填
		{
			magic[row][col] = i;//若输入的是偶数，则会行数下标越界
			magout[row][col]=Integer.toString(i);
			if (i % n == 0)//如果已经填了n个了
				row++;//转到下一行
			else 
			{
				if (row == 0)//如果是第一行则转到最后一行
					row = n - 1;
				else
					row--;//若不是就转到上一行
				if (col == (n - 1))
					col = 0;//如果是最后一列了，转到第一列
				else
					col++;//若不是就转到下一列
			} 
		}
		for (i = 0; i < n; i++) 
		{
			for (j = 0; j < n; j++)
				System.out.print(magic[i][j] + "\t");
		System.out.println();
		}
		try {
			OutputStreamWriter fout = null;//定义一个流 。
			fout = new OutputStreamWriter(new FileOutputStream("D:\\JAVA\\sourse\\Lab1-1190201104\\src\\txt\\6.txt"),"GBK");
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
		   try//按行读入字符串，s中存放的是每一行的内容
		    {
		    	FileInputStream fin=new FileInputStream("D:\\JAVA\\sourse\\Lab1-1190201104\\src\\txt\\"+fileName);
		    	InputStreamReader reader = new InputStreamReader(fin);
		    	BufferedReader buffReader = new BufferedReader(reader);		    	
		    	String strtmp;
		    	while((strtmp = buffReader.readLine())!=null)
		    	{
	        	 s[i]=strtmp;
	        	 i++;	 
		    	}
		    	buffReader.close();//关闭
		    }catch (Exception e) {
		    	e.printStackTrace();
			} 
		 
		    int length=i;//length记录行数
		    //用width记录每一行的数字个数
		    int width0[]=new int[length];
		    for(i=0;i<length;i++)
		    {   
			  width0[i]=(s[i].split("\t")).length;
			  if(length != width0[i] )
			  {   
				  if(i>0)//若开始几行行列相等，后面不相等，那肯定不是矩阵
					  System.out.print("并非矩阵");
				  else if(i==0 && width0[0]==s[1].split("\t").length)
					  System.out.print("行列数不相等");//如果一开始就不相等那就不是正方形
				  ret=false;
				  return ret;
			  }
			  
		    }
		    int width=width0[0];//如果运行到这里那肯定是行列数量相等		  
		    String [][]ss= new String[length][width];
		    int [][]num = new int[length][width];
		    for(i=0;s[i]!=null;i++) 
		    {
			  ss[i]=s[i].split("\t");//用二维字符串数组记录数据
		    }		  		  
		    for(i=0;i<ss.length;i++)
		    {   for(j=0;j<ss[i].length;j++)
	      		{
	    	       num[i][j]=Integer.valueOf(ss[i][j]);//把字符串转化为数字
	    	       if(num[i][j]<0)
	    	       {   
	    	    	   System.out.print("存在负数");
	    	    	   ret=false;
	 				   return ret;
	    	       }
	      		}
		    }
		    int sum=0;//sum存的是第一行的值的和
		    int sum0=0;//sum0用存每一行或列的值的和
		    int sum1=0;
		    //得出第一行的值的和
		    for(j=0;j<length;j++)
	      	{
	    	  sum+=num[0][j];        
	      	}
		    //按行列比较
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
	    		  System.out.print("和不满足");
	    		  break;
	    	  }
		    }
		    //对角比较
		    sum1=0;
		    sum0=0;
		    for(i=0;i<length;i++)
		    {    
	    	  sum0+=num[i][i];
	    	  sum1+=num[i][length-i-1];
		    }
		    if(sum0!=sum && sum1 !=sum)
		    {   
	    	  System.out.print("和不满足");
	    	  ret=false;
		    }	      
		    return ret;
	}
	public static void main(String[] args)   {
		String txt[]= {"1.txt","2.txt","3.txt","4.txt","5.txt",};
		int num=txt.length;
		int n;
		boolean equal;//把名字存在数组中，轮流放入判断
		for(int i=0;i<num;i++)
		{
			System.out.print("第"+(i+1)+"个矩阵：");
		    equal=isLegalMagicSquare(txt[i]);
			System.out.println(equal);
		}
		Scanner in = new Scanner(System.in);
		n=in.nextInt();
		generateMagicSquare(n);
	   }    
}

	


