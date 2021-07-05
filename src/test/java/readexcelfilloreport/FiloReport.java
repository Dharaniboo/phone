package readexcelfilloreport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

 

import org.aspectj.bridge.AbortException;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;


public class FiloReport {


	 
		
	

		 

		 

	 
		    public void readExecl() throws AbortException, IOException, FilloException {
		        String filePath = new File("Data\\phone list.xlsx").getAbsolutePath();
		        Fillo fillo = new Fillo();
		        Connection connection = fillo.getConnection(filePath);
		        String strQuery = "Select * from Sheet1";

		 

		        Recordset recordset = connection.executeQuery(strQuery);

		 

		        System.out.println(recordset.getCount());
		        while (recordset.next()) {
		            System.out.println(recordset.getField("phone") + ":" + recordset.getField("color") + ":" + recordset.getField("cost"));
		        }

		 

		        recordset.close();
		        connection.close();

		 

		    }

		 

		    public static void main(String args[]) throws AbortException, IOException, FilloException {
		       FiloReport DT = new FiloReport();
		        DT.readExecl();
		    }
		
	}


