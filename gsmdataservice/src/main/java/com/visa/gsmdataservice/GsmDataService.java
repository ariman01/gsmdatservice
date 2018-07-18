package com.visa.gsmdataservice;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;



import org.apache.commons.cli.ParseException;

/**
 * Hello world!
 *
 */
import com.google.gson.*;
public class GsmDataService 
{
    public static void main( String[] args )
    {
    	CommandLineParser cliParser = new DefaultParser();
    	Options clOptions = new Options();
    	clOptions.addOption("h","help",false,"Quick help for command options")
    	.addOption("p", "project", true,"Project Id")
    	.addOption("d","display",false,"Display Project Metrics <default>")
    	.addOption("u","update",false,"Display and update database with project metrics");
    	CommandLineParser parser = new DefaultParser();
    	HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;
        Boolean updateDatabase = false;
		try {
			cmd = cliParser.parse( clOptions, args);
			if(cmd.hasOption("h")) { 
	        	formatter.printHelp("GsmDataService ", clOptions);
	        }else if(!cmd.hasOption("p")){
	        	System.out.println("Project information is required");
	        	formatter.printHelp("GsmDataService ", clOptions);
	        }else{
	        	String projectName = cmd.getOptionValue("p");
	        	updateDatabase = cmd.hasOption("u") == true;
	        	System.out.println("Executing Command..."+projectName+updateDatabase);
	        }
		} catch (ParseException e) {
			System.out.println("Error: Not a valid command !!!");
			formatter.printHelp("GsmDataService ", clOptions);
		}
         
    }
}
