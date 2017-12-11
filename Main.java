package MST;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
/*
 * Open file and read
 */
		Scanner input = new Scanner(System.in);
		ReadFile r = new ReadFile();
		System.out.println("Please input the input path.");
		String a= input.next();
		r.openFile(a);
		input.close();
/*
 * for Prim part
 */		
		Prim p = new Prim();
		p.PrimAlgorithm(a);
		String pout = p.printPrim();
/*
 * for Kruskal part
 */
		Kruskal k = new Kruskal();
		k.KruskalAlgorithm(a);
		String kout = k.printKruskal();
		
		try
		{
		String filename1="prim.out";
		String filename2="kruskal.out";
		FileWriter file1=new FileWriter(filename1,false);
		FileWriter file2=new FileWriter(filename2,false);
		BufferedWriter writer1=new BufferedWriter(file1);
		BufferedWriter writer2=new BufferedWriter(file2);
			
			writer1.write(pout);
			writer2.write(kout);	
			writer1.close();
			writer2.close();
		}catch(Exception e)
		{
			System.out.println("Error");
		}
		System.out.println("Finished");

	}

}
