
package com.poc.yugabyte.model;

import java.lang.reflect.Modifier;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.poc.yugabyte.common.GatewayResponseTimeDeserializer;
import com.poc.yugabyte.common.LastTxnResponseCodeDeserializer;
import com.poc.yugabyte.common.StringToBoolCodeDeserializer;
import com.poc.yugabyte.common.TimestampDeserializerNew;
import com.poc.yugabyte.common.TxnDateDeserializer;
import com.poc.yugabyte.common.TxnTimestampDeserializer;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Upi implements TransactionInfc {
	@JsonProperty("payeeAccountNo")
	private String payeeaccountno;
	@JsonProperty("payerGeoCode")
	private String payergeocode;
	@JsonProperty("payerMcc")
	private String payermcc;
	@JsonProperty("txnDateTime")
	@JsonDeserialize(using = TxnTimestampDeserializer.class)
	private Timestamp txndatetime;
	@JsonProperty("RRN")
	private String rrn;
	@JsonProperty("payerMobile")
	private String payermobile;
	@JsonProperty("txnTime")
	private String txntime;
	@JsonProperty("txnSubType")
	private String txnsubtype;
	@JsonProperty("responseCode")
	private String responsecode;
	@JsonProperty("offlineFlag")
	private Boolean offlineflag;
	@JsonProperty("payeeVpa")
	private String payeevpa;
	@JsonProperty("txnType")
	private String txntype;
	@JsonProperty("payeeVerifiedName")
	private String payeeverifiedname;
	@JsonProperty("mcc")
	private String mcc;
	@JsonProperty("payeeMobile")
	private String payeemobile;
	@JsonProperty("payerDeviceId")
	private String payerdeviceid;
	@JsonProperty("originalTxnId")
	private String originaltxnid;
	@JsonProperty("payerVpa")
	private String payervpa;
	@JsonProperty("payeeIfsc")
	private String payeeifsc;
	@JsonProperty("txnId")
	private String txnid;
	@JsonProperty("payeeAmount")
	private Double payeeamount;
	@JsonProperty("payeeDeviceId")
	private String payeedeviceid;
	@JsonProperty("payerAccountNo")
	private String payeraccountno;
	@JsonProperty("payerIfsc")
	private String payerifsc;
	@JsonProperty("txnAmount")
	private String txnamount;
	@JsonProperty("remitterOrgId")
	private String remitterorgid;
	@JsonProperty("beneficiaryOrgId")
	private String beneficiaryorgid;
	@JsonProperty("lastTxnAmount")
	private Double lasttxnamount;
	@JsonProperty("lastTxnResponseCode")
	@JsonDeserialize(using = LastTxnResponseCodeDeserializer.class)
	private Boolean lasttxnresponsecode;
	@JsonProperty("payeeName")
	private String payeename;
	@JsonProperty("lastTxnIntrvl")
	private String lasttxnintrvl;
	@JsonProperty("lastTxnDist")
	private String lasttxndist;
	private String payeepspcd;
	private String payerpspcd;
	@JsonProperty("isAbnormalHourTxn")
	private Boolean isabnormalhourtxn;
	@JsonProperty("isDeclinedTxn")
	private Boolean isdeclinedtxn;
	@JsonProperty("isSunday")
	private Boolean issunday;
	@JsonProperty("localityType")
	private String localitytype;
	private String state;
	@JsonProperty("timeOfDay")
	private String timeofday;
	@JsonProperty("payeeMobileenc")
	private String payeemobileenc;
	@JsonProperty("payerAccountNoenc")
	private String payeraccountnoenc;
	@JsonProperty("payeeAccountNoenc")
	private String payeeaccountnoenc;
	@JsonProperty("payerMobileenc")
	private String payermobileenc;
	@JsonProperty("beneficiaryModelScore")
	private Integer beneficiarymodelscore;
	@JsonProperty("beneficiaryRiskScore")
	private Integer beneficiaryriskscore;
	@JsonProperty("beneficiaryRuleScore")
	private Integer beneficiaryrulescore;
	@JsonProperty("finalRiskScore")
	private Integer finalriskscore;
	@JsonProperty("remitterModelScore")
	private Integer remittermodelscore;
	@JsonProperty("remitterRiskScore")
	private Integer remitterriskscore;
	@JsonProperty("remitterRuleScore")
	private Integer remitterrulescore;
	@JsonProperty("GATEWAY_REQUEST_TIME")
	@JsonDeserialize(using = GatewayResponseTimeDeserializer.class)
	private Timestamp gatewayrequesttime;
	@JsonProperty("GATEWAY_RESPONSE_TIME")
	@JsonDeserialize(using = GatewayResponseTimeDeserializer.class)
	private Timestamp gatewayresponstime;
	@JsonProperty("sourceJvm")
	private String sourcejvm;
	private String channel;
	@JsonProperty("payerName")
	private String payername;
	@JsonProperty("payerVerifiedName")
	private String payerverifiedname;
	@JsonProperty("offlineTxn")
	private Boolean offlinetxn;
	@JsonProperty("payerVpaenc")
	private String payervpaenc;
	@JsonProperty("payeeVpaenc")
	private String payeevpaenc;
	@JsonProperty("payerDeviceAppId")
	private String payerdeviceappid;
	@JsonProperty("payerDeviceOs")
	private String payerdeviceos;
	@JsonProperty("txnInitiationMode")
	private String txninitiationmode;
	@JsonProperty("payerDeviceRegTs")
	@JsonDeserialize(using = TimestampDeserializerNew.class)
	private Timestamp payerdeviceregts;
	@JsonProperty("payerDeviceRotationTs")
	@JsonDeserialize(using = TimestampDeserializerNew.class)
	private Timestamp payerdevicerotationts;
	@JsonProperty("payeeMrchType")
	private String whitelistedentry;
	@JsonProperty("txnPurpose")
	private String txnpurpose;
	@JsonProperty("payerInstConCode")
	private String payerinstconcode;
	@JsonProperty("payeeAmountSplitBaseAmount")
	private Double payeeamountsplitbaseamount;
	@JsonProperty("payerMrchIdentifierLocation")
	private String payermrchidentifierlocation;
	@JsonProperty("payeeMrchIdentifierLocation")
	private String payeemrchidentifierlocation;
	@JsonProperty("payerMrchIdentifierInstCode")
	private String payermrchidentifierinstcode;
	@JsonProperty("payeeMrchIdentifierInstCode")
	private String payeemrchidentifierinstcode;
	@JsonProperty("txnUpiSubType")
	private String txnupisubtype;
	@JsonProperty("npciModelScore")
	private Integer npcimodelscore;
	@JsonProperty("rsModelScoreOld")
	private Integer rsmodelscoreold;
	@JsonProperty("rsModelScoreNew")
	private Integer rsmodelscorenew;
	@JsonProperty("txnUpiType")
	private String txnupitype;
	@JsonProperty("txnApiName")
	private String txnapiname;
	@JsonProperty("mandateUmn")
	private String mandateumn;
	@JsonProperty("mandateRecurrencePattern")
	private String mandaterecurrencepattern;
	@JsonProperty("mandateBlockFund")
	@JsonDeserialize(using = StringToBoolCodeDeserializer.class)
	private Boolean mandateblockfund;
	@JsonProperty("mandateRule")
	private String mandaterule;
	@JsonProperty("mandateValidityEndDate")
	private String mandatevalidityenddate;
	@JsonProperty("txnNote")
	private String txnnote;
	@JsonProperty("payerDeviceIdenc")
	private String payerdeviceidenc;
	@JsonProperty("payeeDeviceIdenc")
	private String payeedeviceidenc;
	@JsonProperty("payeeVerifiedNameenc")
	private String payeeverifiednameenc;
	@JsonProperty("payerVerifiedNameenc")
	private String payerverifiednameenc;
	@JsonProperty("payeeNameenc")
	private String payeenameenc;
	@JsonProperty("payerNameenc")
	private String payernameenc;
	@JsonProperty("initiatedBy")
	private String initiatedby;
	@JsonProperty("payeeMrchGenre")
	private String payeemrchgenre;
	@JsonProperty("payeeMrchOnBoardingType")
	private String payeemrchonboardingtype;
	@JsonProperty("payeeMrchSubCode")
	private String payeemrchsubcode;
	@JsonProperty("payeeCmId")
	private String payeecmid;
	@JsonProperty("payerDeviceType")
	private String payerdevicetype;
	@JsonProperty("payeeDeviceType")
	private String payeedevicetype;
//	@JsonProperty("frmTxnId")
//	private String frmtxnid;
//	@JsonProperty("jvmRoute")
//	private String jvmroute;
	@JsonProperty("payerAccountType")
	private String payeraccounttype;
	@JsonProperty("payeeAccountType")
	private String payeeaccounttype;
	@JsonProperty("payerAddressType")
	private String payeraddresstype;
	@JsonProperty("payeeAddressType")
	private String payeeaddresstype;
	@JsonProperty("txnDate")
	@JsonDeserialize(using = TxnDateDeserializer.class)
	private Date txndate;

	private static int fieldCount;
	static {
		fieldCount = (int) Arrays.stream(Upi.class.getDeclaredFields())
				.filter(f -> !Modifier.isStatic(f.getModifiers())).count();
	}

	@Override
	public void populate(PreparedStatement ps, int rowNum) throws SQLException {
		System.out.println("Field Count = " + fieldCount);
		ps.setObject(1, payeeaccountno);
		ps.setObject(2, payergeocode);
		ps.setObject(3, payermcc);
		ps.setObject(4, txndatetime);
		ps.setObject(5, rrn);
		ps.setObject(6, payermobile);
		ps.setObject(7, txntime);
		ps.setObject(8, txnsubtype);
		ps.setObject(9, responsecode);
		ps.setObject(10, offlineflag);
		ps.setObject(11, payeevpa);
		ps.setObject(12, txntype);
		ps.setObject(13, payeeverifiedname);
		ps.setObject(14, mcc);
		ps.setObject(15, payeemobile);
		ps.setObject(16, payerdeviceid);
		ps.setObject(17, originaltxnid);
		ps.setObject(18, payervpa);
		ps.setObject(19, payeeifsc);
		ps.setObject(20, txnid);
		ps.setObject(21, payeeamount);
		ps.setObject(22, payeedeviceid);
		ps.setObject(23, payeraccountno);
		ps.setObject(24, payerifsc);
		ps.setObject(25, Double.parseDouble(txnamount));
		ps.setObject(26, remitterorgid);
		ps.setObject(27, beneficiaryorgid);
		ps.setObject(28, lasttxnamount);
		ps.setObject(29, lasttxnresponsecode);
		ps.setObject(30, payeename);
		ps.setObject(31, Double.parseDouble(lasttxnintrvl));
		ps.setObject(32, Double.parseDouble(lasttxndist));
		ps.setObject(33, payeepspcd);
		ps.setObject(34, payerpspcd);
		ps.setObject(35, isabnormalhourtxn);
		ps.setObject(36, isdeclinedtxn);
		ps.setObject(37, issunday);
		ps.setObject(38, localitytype);
		ps.setObject(39, state);
		ps.setObject(40, timeofday);
		ps.setObject(41, payeemobileenc);
		ps.setObject(42, payeraccountnoenc);
		ps.setObject(43, payeeaccountnoenc);
		ps.setObject(44, payermobileenc);
		ps.setObject(45, beneficiarymodelscore);
		ps.setObject(46, beneficiaryriskscore);
		ps.setObject(47, beneficiaryrulescore);
		ps.setObject(48, finalriskscore);
		ps.setObject(49, remittermodelscore);
		ps.setObject(50, remitterriskscore);
		ps.setObject(51, remitterrulescore);
		ps.setObject(52, gatewayrequesttime);
		ps.setObject(53, gatewayresponstime);
		ps.setObject(54, sourcejvm);
		ps.setObject(55, channel);
		ps.setObject(56, payername);
		ps.setObject(57, payerverifiedname);
		ps.setObject(58, offlinetxn);
		ps.setObject(59, payervpaenc);
		ps.setObject(60, payeevpaenc);
		ps.setObject(61, payerdeviceappid);
		ps.setObject(62, payerdeviceos);
		ps.setObject(63, txninitiationmode);
		ps.setObject(64, payerdeviceregts);
		ps.setObject(65, payerdevicerotationts);
		ps.setObject(66, whitelistedentry);
		ps.setObject(67, txnpurpose);
		ps.setObject(68, payerinstconcode);
		ps.setObject(69, payeeamountsplitbaseamount);
		ps.setObject(70, payermrchidentifierlocation);
		ps.setObject(71, payeemrchidentifierlocation);
		ps.setObject(72, payermrchidentifierinstcode);
		ps.setObject(73, payeemrchidentifierinstcode);
		ps.setObject(74, txnupisubtype);
		ps.setObject(75, npcimodelscore);
		ps.setObject(76, rsmodelscoreold);
		ps.setObject(77, rsmodelscorenew);
		ps.setObject(78, txnupitype);
		ps.setObject(79, txnapiname);
		ps.setObject(80, mandateumn);
		ps.setObject(81, mandaterecurrencepattern);
		ps.setObject(82, mandateblockfund);
		ps.setObject(83, mandaterule);
		ps.setObject(84, mandatevalidityenddate);
		ps.setObject(85, txnnote);
		ps.setObject(86, payerdeviceidenc);
		ps.setObject(87, payeedeviceidenc);
		ps.setObject(88, payeeverifiednameenc);
		ps.setObject(89, payerverifiednameenc);
		ps.setObject(90, payeenameenc);
		ps.setObject(91, payernameenc);
		ps.setObject(92, initiatedby);
		ps.setObject(93, payeemrchgenre);
		ps.setObject(94, payeemrchonboardingtype);
		ps.setObject(95, payeemrchsubcode);
		ps.setObject(96, payeecmid);
		ps.setObject(97, payerdevicetype);
		ps.setObject(98, payeedevicetype);
		ps.setObject(99, payeraccounttype);
		ps.setObject(100, payeeaccounttype);
		ps.setObject(101, payeraddresstype);
		ps.setObject(102, payeeaddresstype);
		ps.setObject(103, txndate);
	}

	@Override
	public String getPlaceHolders() {
		return "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	}

	@Override
	public String getInsertFragment() {
		return "INSERT INTO efrm.dw_for_upi "
				+ "(payeeaccountno,payergeocode,payermcc,txndatetime,rrn,payermobile,txntime,txnsubtype,responsecode,offlineflag,payeevpa,txntype,payeeverifiedname,mcc,payeemobile,payerdeviceid,originaltxnid,payervpa,payeeifsc,txnid,payeeamount,payeedeviceid,payeraccountno,payerifsc,txnamount,remitterorgid,beneficiaryorgid,lasttxnamount,lasttxnresponsecode,payeename,lasttxnintrvl,lasttxndist,payeepspcd,payerpspcd,isabnormalhourtxn,isdeclinedtxn,issunday,localitytype,state,timeofday,payeemobileenc,payeraccountnoenc,payeeaccountnoenc,payermobileenc,beneficiarymodelscore,beneficiaryriskscore,beneficiaryrulescore,finalriskscore,remittermodelscore,remitterriskscore,remitterrulescore,gatewayrequesttime,gatewayresponstime,sourcejvm,channel,payername,payerverifiedname,offlinetxn,payervpaenc,payeevpaenc,payerdeviceappid,payerdeviceos,txninitiationmode,payerdeviceregts,payerdevicerotationts,whitelistedentry,txnpurpose,payerinstconcode,payeeamountsplitbaseamount,payermrchidentifierlocation,payeemrchidentifierlocation,payermrchidentifierinstcode,payeemrchidentifierinstcode,txnupisubtype,npcimodelscore,rsmodelscoreold,rsmodelscorenew,txnupitype,txnapiname,mandateumn,mandaterecurrencepattern,mandateblockfund,mandaterule,mandatevalidityenddate,txnnote,payerdeviceidenc,payeedeviceidenc,payeeverifiednameenc,payerverifiednameenc,payeenameenc,payernameenc,initiatedby,payeemrchgenre,payeemrchonboardingtype,payeemrchsubcode,payeecmid,payerdevicetype,payeedevicetype,payeraccounttype,payeeaccounttype,payeraddresstype,payeeaddresstype,txndate) values ";
	}

//	public static void main(String[] args) {
//		Field[] declaredFields = Upi.class.getDeclaredFields();
//		StringBuilder sb = new StringBuilder();
//		StringBuilder sbValues = new StringBuilder();
//
//		int i = 1;
//		sb.append("INSERT INTO npciefrm.dw_for_upi (");
//		sbValues.append('(');
//		for (Field field : declaredFields) {
//			// sb.append("ps.setObject( fieldCount *(rowNum -1) +").append(i++).append(",
//			// ").append(field.getName()).append(");\n");
//
//			sb.append(field.getName()).append(',');
//			sbValues.append('?').append(',');
//
//		}
//
//		sbValues.setCharAt(sbValues.length() - 1, ')');
//		sb.setCharAt(sb.length() - 1, ')');
//		sb.append(" values ");
//
//		
//		
//		System.out.println(sb);
//		System.out.println(sbValues);
//	}
}
