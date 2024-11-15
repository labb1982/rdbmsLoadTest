package com.poc.yugabyte.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Util {
	private static Predicate<Field> fieldFilter;
	private static final Logger log = LoggerFactory.getLogger(com.poc.yugabyte.common.Util.class);

	private Util() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}

	public static String runLinuxCommand(String command) {
		ProcessBuilder processBuilder = new ProcessBuilder(new String[0]);
		processBuilder.command(new String[] { "bash", "-c", command });

		try {
			Process process = processBuilder.start();

			StringBuilder output = new StringBuilder();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line + "\n");
			}

			int exitVal = process.waitFor();
			if (exitVal == 0) {
				return output.toString().trim();
			}
			return "";
		} catch (IOException | InterruptedException e) {
			log.error("Error while executing the linux command {} {}", command, e.getMessage());
			return "";
		}
	}

	public static String getActiveNode(String shellLocation) {
		return runLinuxCommand(shellLocation);
	}

	static {
		fieldFilter = (field -> !field.getName().equals("serialVersionUID"));
	}

//	public static StructType getSchema(Class<? extends Object> clazz) {
//		Field[] fields = clazz.getDeclaredFields();
//		List<StructField> structFields = new LinkedList<>();
//		Arrays.<Field>asList(fields).stream().filter(fieldFilter).forEach(field -> {
//			DataType dbType = null;
//			switch (field.getType().getSimpleName()) {
//			case "String":
//				dbType = DataTypes.StringType;
//				break;
//			case "Integer":
//				dbType = DataTypes.IntegerType;
//				break;
//			case "Boolean":
//				dbType = DataTypes.BooleanType;
//				break;
//			case "Float":
//				dbType = DataTypes.FloatType;
//				break;
//			case "Long":
//				dbType = DataTypes.LongType;
//				break;
//			case "Date":
//				dbType = DataTypes.DateType;
//				break;
//			case "Double":
//				dbType = DataTypes.DoubleType;
//				break;
//			case "Timestamp":
//				dbType = DataTypes.TimestampType;
//				break;
//			case "BigInteger":
//				dbType = DataTypes.IntegerType;
//				break;
//			default:
//				dbType = DataTypes.StringType;
//				break;
//			}
//			structFields.add(DataTypes.createStructField(field.getName(), dbType, true));
//		});
//		return DataTypes.createStructType(structFields);
//	}
//
	public static Object[] getValuesFromObject(Object object) {
		List<Object> valueList = new LinkedList<Object>();
		Arrays.<Field>asList(object.getClass().getDeclaredFields()).stream().filter(fieldFilter).forEach(field -> {
			field.setAccessible(true);
			try {
				final Object e = field.get(object);
				valueList.add(e);

			} catch (IllegalArgumentException | IllegalAccessException e) {
				log.error("Error in Online Txn Processor while get values from Object :: {}", e.getMessage());
			}
		});
		return valueList.toArray(new Object[valueList.size()]);
	}

	public static String getORCFolderByTime(int divideBy) {
		LocalTime now = LocalTime.now();
		int min = now.getMinute() / divideBy;
		int nextmin = now.plusMinutes(divideBy).getMinute();
		return "efrm-" + now.getHour() + "-" + min + "-" + (nextmin / divideBy);
	}

	public static Map<String, Integer> currencyMap = new HashMap<>();
	static {
		currencyMap.put("AFN", Integer.valueOf(971));
		currencyMap.put("ALL", Integer.valueOf(8));
		currencyMap.put("DZD", Integer.valueOf(12));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("AOA", Integer.valueOf(973));
		currencyMap.put("XCD", Integer.valueOf(951));
		currencyMap.put("XCD", Integer.valueOf(951));
		currencyMap.put("ARS", Integer.valueOf(32));
		currencyMap.put("AMD", Integer.valueOf(51));
		currencyMap.put("AWG", Integer.valueOf(533));
		currencyMap.put("AUD", Integer.valueOf(36));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("AZN", Integer.valueOf(944));
		currencyMap.put("BSD", Integer.valueOf(44));
		currencyMap.put("BHD", Integer.valueOf(48));
		currencyMap.put("BDT", Integer.valueOf(50));
		currencyMap.put("BBD", Integer.valueOf(52));
		currencyMap.put("BYN", Integer.valueOf(933));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("BZD", Integer.valueOf(84));
		currencyMap.put("XOF", Integer.valueOf(952));
		currencyMap.put("BMD", Integer.valueOf(60));
		currencyMap.put("BTN", Integer.valueOf(64));
		currencyMap.put("INR", Integer.valueOf(356));
		currencyMap.put("BOB", Integer.valueOf(68));
		currencyMap.put("BOV", Integer.valueOf(984));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("BAM", Integer.valueOf(977));
		currencyMap.put("BWP", Integer.valueOf(72));
		currencyMap.put("NOK", Integer.valueOf(578));
		currencyMap.put("BRL", Integer.valueOf(986));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("BND", Integer.valueOf(96));
		currencyMap.put("BGN", Integer.valueOf(975));
		currencyMap.put("XOF", Integer.valueOf(952));
		currencyMap.put("BIF", Integer.valueOf(108));
		currencyMap.put("CVE", Integer.valueOf(132));
		currencyMap.put("KHR", Integer.valueOf(116));
		currencyMap.put("XAF", Integer.valueOf(950));
		currencyMap.put("CAD", Integer.valueOf(124));
		currencyMap.put("KYD", Integer.valueOf(136));
		currencyMap.put("XAF", Integer.valueOf(950));
		currencyMap.put("XAF", Integer.valueOf(950));
		currencyMap.put("CLF", Integer.valueOf(990));
		currencyMap.put("CLP", Integer.valueOf(152));
		currencyMap.put("CNY", Integer.valueOf(156));
		currencyMap.put("AUD", Integer.valueOf(36));
		currencyMap.put("AUD", Integer.valueOf(36));
		currencyMap.put("COP", Integer.valueOf(170));
		currencyMap.put("COU", Integer.valueOf(970));
		currencyMap.put("KMF", Integer.valueOf(174));
		currencyMap.put("CDF", Integer.valueOf(976));
		currencyMap.put("XAF", Integer.valueOf(950));
		currencyMap.put("NZD", Integer.valueOf(554));
		currencyMap.put("CRC", Integer.valueOf(188));
		currencyMap.put("HRK", Integer.valueOf(191));
		currencyMap.put("CUC", Integer.valueOf(931));
		currencyMap.put("CUP", Integer.valueOf(192));
		currencyMap.put("ANG", Integer.valueOf(532));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("CZK", Integer.valueOf(203));
		currencyMap.put("XOF", Integer.valueOf(952));
		currencyMap.put("DKK", Integer.valueOf(208));
		currencyMap.put("DJF", Integer.valueOf(262));
		currencyMap.put("XCD", Integer.valueOf(951));
		currencyMap.put("DOP", Integer.valueOf(214));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("EGP", Integer.valueOf(818));
		currencyMap.put("SVC", Integer.valueOf(222));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("XAF", Integer.valueOf(950));
		currencyMap.put("ERN", Integer.valueOf(232));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("ETB", Integer.valueOf(230));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("FKP", Integer.valueOf(238));
		currencyMap.put("DKK", Integer.valueOf(208));
		currencyMap.put("FJD", Integer.valueOf(242));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("XPF", Integer.valueOf(953));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("XAF", Integer.valueOf(950));
		currencyMap.put("GMD", Integer.valueOf(270));
		currencyMap.put("GEL", Integer.valueOf(981));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("GHS", Integer.valueOf(936));
		currencyMap.put("GIP", Integer.valueOf(292));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("DKK", Integer.valueOf(208));
		currencyMap.put("XCD", Integer.valueOf(951));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("GTQ", Integer.valueOf(320));
		currencyMap.put("GBP", Integer.valueOf(826));
		currencyMap.put("GNF", Integer.valueOf(324));
		currencyMap.put("XOF", Integer.valueOf(952));
		currencyMap.put("GYD", Integer.valueOf(328));
		currencyMap.put("HTG", Integer.valueOf(332));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("AUD", Integer.valueOf(36));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("HNL", Integer.valueOf(340));
		currencyMap.put("HKD", Integer.valueOf(344));
		currencyMap.put("HUF", Integer.valueOf(348));
		currencyMap.put("ISK", Integer.valueOf(352));
		currencyMap.put("INR", Integer.valueOf(356));
		currencyMap.put("IDR", Integer.valueOf(360));
		currencyMap.put("XDR", Integer.valueOf(960));
		currencyMap.put("IRR", Integer.valueOf(364));
		currencyMap.put("IQD", Integer.valueOf(368));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("GBP", Integer.valueOf(826));
		currencyMap.put("ILS", Integer.valueOf(376));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("JMD", Integer.valueOf(388));
		currencyMap.put("JPY", Integer.valueOf(392));
		currencyMap.put("GBP", Integer.valueOf(826));
		currencyMap.put("JOD", Integer.valueOf(400));
		currencyMap.put("KZT", Integer.valueOf(398));
		currencyMap.put("KES", Integer.valueOf(404));
		currencyMap.put("AUD", Integer.valueOf(36));
		currencyMap.put("KPW", Integer.valueOf(408));
		currencyMap.put("KRW", Integer.valueOf(410));
		currencyMap.put("KWD", Integer.valueOf(414));
		currencyMap.put("KGS", Integer.valueOf(417));
		currencyMap.put("LAK", Integer.valueOf(418));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("LBP", Integer.valueOf(422));
		currencyMap.put("LSL", Integer.valueOf(426));
		currencyMap.put("ZAR", Integer.valueOf(710));
		currencyMap.put("LRD", Integer.valueOf(430));
		currencyMap.put("LYD", Integer.valueOf(434));
		currencyMap.put("CHF", Integer.valueOf(756));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("MOP", Integer.valueOf(446));
		currencyMap.put("MGA", Integer.valueOf(969));
		currencyMap.put("MWK", Integer.valueOf(454));
		currencyMap.put("MYR", Integer.valueOf(458));
		currencyMap.put("MVR", Integer.valueOf(462));
		currencyMap.put("XOF", Integer.valueOf(952));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("MRU", Integer.valueOf(929));
		currencyMap.put("MUR", Integer.valueOf(480));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("XUA", Integer.valueOf(965));
		currencyMap.put("MXN", Integer.valueOf(484));
		currencyMap.put("MXV", Integer.valueOf(979));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("MDL", Integer.valueOf(498));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("MNT", Integer.valueOf(496));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("XCD", Integer.valueOf(951));
		currencyMap.put("MAD", Integer.valueOf(504));
		currencyMap.put("MZN", Integer.valueOf(943));
		currencyMap.put("MMK", Integer.valueOf(104));
		currencyMap.put("NAD", Integer.valueOf(516));
		currencyMap.put("ZAR", Integer.valueOf(710));
		currencyMap.put("AUD", Integer.valueOf(36));
		currencyMap.put("NPR", Integer.valueOf(524));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("XPF", Integer.valueOf(953));
		currencyMap.put("NZD", Integer.valueOf(554));
		currencyMap.put("NIO", Integer.valueOf(558));
		currencyMap.put("XOF", Integer.valueOf(952));
		currencyMap.put("NGN", Integer.valueOf(566));
		currencyMap.put("NZD", Integer.valueOf(554));
		currencyMap.put("AUD", Integer.valueOf(36));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("NOK", Integer.valueOf(578));
		currencyMap.put("OMR", Integer.valueOf(512));
		currencyMap.put("PKR", Integer.valueOf(586));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("PAB", Integer.valueOf(590));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("PGK", Integer.valueOf(598));
		currencyMap.put("PYG", Integer.valueOf(600));
		currencyMap.put("PEN", Integer.valueOf(604));
		currencyMap.put("PHP", Integer.valueOf(608));
		currencyMap.put("NZD", Integer.valueOf(554));
		currencyMap.put("PLN", Integer.valueOf(985));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("QAR", Integer.valueOf(634));
		currencyMap.put("MKD", Integer.valueOf(807));
		currencyMap.put("RON", Integer.valueOf(946));
		currencyMap.put("RUB", Integer.valueOf(643));
		currencyMap.put("RWF", Integer.valueOf(646));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("SHP", Integer.valueOf(654));
		currencyMap.put("XCD", Integer.valueOf(951));
		currencyMap.put("XCD", Integer.valueOf(951));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("XCD", Integer.valueOf(951));
		currencyMap.put("WST", Integer.valueOf(882));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("STN", Integer.valueOf(930));
		currencyMap.put("SAR", Integer.valueOf(682));
		currencyMap.put("XOF", Integer.valueOf(952));
		currencyMap.put("RSD", Integer.valueOf(941));
		currencyMap.put("SCR", Integer.valueOf(690));
		currencyMap.put("SLL", Integer.valueOf(694));
		currencyMap.put("SGD", Integer.valueOf(702));
		currencyMap.put("ANG", Integer.valueOf(532));
		currencyMap.put("XSU", Integer.valueOf(994));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("SBD", Integer.valueOf(90));
		currencyMap.put("SOS", Integer.valueOf(706));
		currencyMap.put("ZAR", Integer.valueOf(710));
		currencyMap.put("SSP", Integer.valueOf(728));
		currencyMap.put("EUR", Integer.valueOf(978));
		currencyMap.put("LKR", Integer.valueOf(144));
		currencyMap.put("SDG", Integer.valueOf(938));
		currencyMap.put("SRD", Integer.valueOf(968));
		currencyMap.put("NOK", Integer.valueOf(578));
		currencyMap.put("SZL", Integer.valueOf(748));
		currencyMap.put("SEK", Integer.valueOf(752));
		currencyMap.put("CHE", Integer.valueOf(947));
		currencyMap.put("CHF", Integer.valueOf(756));
		currencyMap.put("CHW", Integer.valueOf(948));
		currencyMap.put("SYP", Integer.valueOf(760));
		currencyMap.put("TWD", Integer.valueOf(901));
		currencyMap.put("TJS", Integer.valueOf(972));
		currencyMap.put("TZS", Integer.valueOf(834));
		currencyMap.put("THB", Integer.valueOf(764));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("XOF", Integer.valueOf(952));
		currencyMap.put("NZD", Integer.valueOf(554));
		currencyMap.put("TOP", Integer.valueOf(776));
		currencyMap.put("TTD", Integer.valueOf(780));
		currencyMap.put("TND", Integer.valueOf(788));
		currencyMap.put("TRY", Integer.valueOf(949));
		currencyMap.put("TMT", Integer.valueOf(934));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("AUD", Integer.valueOf(36));
		currencyMap.put("UGX", Integer.valueOf(800));
		currencyMap.put("UAH", Integer.valueOf(980));
		currencyMap.put("AED", Integer.valueOf(784));
		currencyMap.put("GBP", Integer.valueOf(826));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("USN", Integer.valueOf(997));
		currencyMap.put("UYI", Integer.valueOf(940));
		currencyMap.put("UYU", Integer.valueOf(858));
		currencyMap.put("UZS", Integer.valueOf(860));
		currencyMap.put("VUV", Integer.valueOf(548));
		currencyMap.put("VEF", Integer.valueOf(937));
		currencyMap.put("VND", Integer.valueOf(704));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("USD", Integer.valueOf(840));
		currencyMap.put("XPF", Integer.valueOf(953));
		currencyMap.put("MAD", Integer.valueOf(504));
		currencyMap.put("YER", Integer.valueOf(886));
		currencyMap.put("ZMW", Integer.valueOf(967));
		currencyMap.put("ZWL", Integer.valueOf(932));
		currencyMap.put("EUR", Integer.valueOf(978));
	}
}
