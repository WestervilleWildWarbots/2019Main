package frc.robot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Logger {

    public static void Log(String logMessage)
	{
		File file = new File("LoggerFile.txt");
		try 
		{
            PrintWriter log = new PrintWriter(new FileWriter(file, true)); 
            Date now = new Date();
            log.append(now.toString() + " " + logMessage + " ");
	        log.println();
			log.close();
		}
		catch(IOException e)
		{
			
		}
	}

}
