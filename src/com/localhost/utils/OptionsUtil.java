package com.localhost.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;

import com.localhost.VO.OptionsVO;

public class OptionsUtil {

	private static OptionsVO optionsVO;

	public OptionsVO converToObject(String[] args) throws Exception {
		Options options = new Options();

		options.addOption("du", "dbuser", true, "enter database username");
		options.addOption("dp", "dbpassword", true, "enter database password");
		options.addOption("ip", "dbip", true, "enter database ip");
		options.addOption("port", "dbport", true, "enter database port");
		options.addOption("db", "database", true, "enter database name");
		options.addOption("sproject", "sproject", true, "enter source project name");
		options.addOption("tproject", "tproject", true, "enter target project name");
		options.addOption("report", "report", true, "enter report id");
		options.addOption("kpi", "kpi", true, "enter kpi id");
		options.addOption("map", "map", true, "enter map id");
		options.addOption("h", "help", false, "arguments list");

		HelpFormatter formatter = new HelpFormatter();
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = null;
		String sourceProject;
		String targeProject;
		String reportId;
		String kpiId;
		String mapId;
		optionsVO = new OptionsVO();
		
		try {
			cmd = parser.parse(options, args);
			if (cmd.hasOption("h")) {
				formatter.printHelp("HibernateTest.jar", options);
				return null;
			}
			sourceProject = cmd.getOptionValue("sproject", "");
			targeProject = cmd.getOptionValue("tproject", "");
			reportId = cmd.getOptionValue("report", "");
			kpiId = cmd.getOptionValue("kpi", "");
			mapId = cmd.getOptionValue("map", "");
			if (StringUtils.isNotBlank(sourceProject) && StringUtils.isNotBlank(targeProject)) {
				if (StringUtils.isBlank(kpiId) && StringUtils.isBlank(reportId) && StringUtils.isBlank(mapId)) {
					throw new Exception("Please enter kpi id or report id or map id");
				}
			} else {
				throw new Exception("Please ecnter source_project and target project name");
			}

		} catch (ParseException e) {
			throw new Exception(e);
			// formatter.printHelp("help", options);
			// return null;
		}

		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}

			
			optionsVO.setDatabase(cmd.getOptionValue("db", prop.getProperty("db_name")));
			optionsVO.setDatabaseIp(cmd.getOptionValue("ip", prop.getProperty("db_ip")));
			optionsVO.setDatabasePort(cmd.getOptionValue("port", prop.getProperty("db_port")));
			optionsVO.setDbUser(cmd.getOptionValue("du", prop.getProperty("db_user")));
			optionsVO.setDbPassword(cmd.getOptionValue("dp", prop.getProperty("db_password")));
			return optionsVO;
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return null;
	}

	public static OptionsVO getOptionsVO() {
		return optionsVO;
	}

	public static void setOptionsVO(OptionsVO optionsVO) {
		OptionsUtil.optionsVO = optionsVO;
	}

}
