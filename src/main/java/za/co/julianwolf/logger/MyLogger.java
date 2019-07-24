package za.co.julianwolf.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public final class MyLogger{
	public static MyLogger logger = new MyLogger();
	private ArrayList<String> aStrings = new ArrayList<String>();

	private MyLogger(){}

	public void log(String logVal)
	{
		aStrings.add(logVal);
	}

	public void ConsoleLog(String logVal)
	{
		System.console().printf("%s\n", logVal);
	}

	public void PrintToFile()
	{
		try
		{
			if (aStrings.size() == 0)
				return;
			this.ConsoleLog("Printing to File...\nLogging to console\n\n");
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Swingy-debug-consolelogs.txt", true));
			for (String s : aStrings) {
				bufferedWriter.write(s);
				this.ConsoleLog(s);
				bufferedWriter.write("\n");
			}
			bufferedWriter.close();
		} catch (Exception e)
		{
			this.ConsoleLog("Failed to print to file :: " + e);
		}
	}
}
