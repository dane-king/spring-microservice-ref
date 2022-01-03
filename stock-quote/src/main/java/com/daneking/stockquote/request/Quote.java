
package com.daneking.stockquote.request;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "adp_100",
    "adp_200",
    "adp_50",
    "adv_21",
    "adv_30",
    "adv_90",
    "ask",
    "ask_time",
    "asksz",
    "basis",
    "beta",
    "bid",
    "bid_time",
    "bidsz",
    "bidtick",
    "chg",
    "chg_sign",
    "chg_t",
    "cl",
    "contract_size",
    "cusip",
    "date",
    "datetime",
    "days_to_expiration",
    "div",
    "divexdate",
    "divfreq",
    "divpaydt",
    "dollar_value",
    "eps",
    "exch",
    "exch_desc",
    "hi",
    "iad",
    "idelta",
    "igamma",
    "imp_volatility",
    "incr_vl",
    "irho",
    "issue_desc",
    "itheta",
    "ivega",
    "last",
    "lo",
    "name",
    "op_delivery",
    "op_flag",
    "op_style",
    "op_subclass",
    "openinterest",
    "opn",
    "opt_val",
    "pchg",
    "pchg_sign",
    "pcls",
    "pe",
    "phi",
    "plo",
    "popn",
    "pr_adp_100",
    "pr_adp_200",
    "pr_adp_50",
    "pr_date",
    "pr_openinterest",
    "prbook",
    "prchg",
    "prem_mult",
    "put_call",
    "pvol",
    "qcond",
    "rootsymbol",
    "secclass",
    "sesn",
    "sho",
    "strikeprice",
    "symbol",
    "tcond",
    "timestamp",
    "tr_num",
    "tradetick",
    "trend",
    "under_cusip",
    "undersymbol",
    "vl",
    "volatility12",
    "vwap",
    "wk52hi",
    "wk52hidate",
    "wk52lo",
    "wk52lodate",
    "xdate",
    "xday",
    "xmonth",
    "xyear",
    "yield"
})
@Generated("jsonschema2pojo")
public class Quote {

    @JsonProperty("adp_100")
    private String adp100;
    @JsonProperty("adp_200")
    private String adp200;
    @JsonProperty("adp_50")
    private String adp50;
    @JsonProperty("adv_21")
    private String adv21;
    @JsonProperty("adv_30")
    private String adv30;
    @JsonProperty("adv_90")
    private String adv90;
    @JsonProperty("ask")
    private String ask;
    @JsonProperty("ask_time")
    private String askTime;
    @JsonProperty("asksz")
    private String asksz;
    @JsonProperty("basis")
    private String basis;
    @JsonProperty("beta")
    private String beta;
    @JsonProperty("bid")
    private String bid;
    @JsonProperty("bid_time")
    private String bidTime;
    @JsonProperty("bidsz")
    private String bidsz;
    @JsonProperty("bidtick")
    private String bidtick;
    @JsonProperty("chg")
    private String chg;
    @JsonProperty("chg_sign")
    private String chgSign;
    @JsonProperty("chg_t")
    private String chgT;
    @JsonProperty("cl")
    private String cl;
    @JsonProperty("contract_size")
    private String contractSize;
    @JsonProperty("cusip")
    private String cusip;
    @JsonProperty("date")
    private String date;
    @JsonProperty("datetime")
    private String datetime;
    @JsonProperty("days_to_expiration")
    private String daysToExpiration;
    @JsonProperty("div")
    private String div;
    @JsonProperty("divexdate")
    private String divexdate;
    @JsonProperty("divfreq")
    private String divfreq;
    @JsonProperty("divpaydt")
    private String divpaydt;
    @JsonProperty("dollar_value")
    private String dollarValue;
    @JsonProperty("eps")
    private String eps;
    @JsonProperty("exch")
    private String exch;
    @JsonProperty("exch_desc")
    private String exchDesc;
    @JsonProperty("hi")
    private String hi;
    @JsonProperty("iad")
    private String iad;
    @JsonProperty("idelta")
    private String idelta;
    @JsonProperty("igamma")
    private String igamma;
    @JsonProperty("imp_volatility")
    private String impVolatility;
    @JsonProperty("incr_vl")
    private String incrVl;
    @JsonProperty("irho")
    private String irho;
    @JsonProperty("issue_desc")
    private String issueDesc;
    @JsonProperty("itheta")
    private String itheta;
    @JsonProperty("ivega")
    private String ivega;
    @JsonProperty("last")
    private String last;
    @JsonProperty("lo")
    private String lo;
    @JsonProperty("name")
    private String name;
    @JsonProperty("op_delivery")
    private String opDelivery;
    @JsonProperty("op_flag")
    private String opFlag;
    @JsonProperty("op_style")
    private String opStyle;
    @JsonProperty("op_subclass")
    private String opSubclass;
    @JsonProperty("openinterest")
    private String openinterest;
    @JsonProperty("opn")
    private String opn;
    @JsonProperty("opt_val")
    private String optVal;
    @JsonProperty("pchg")
    private String pchg;
    @JsonProperty("pchg_sign")
    private String pchgSign;
    @JsonProperty("pcls")
    private String pcls;
    @JsonProperty("pe")
    private String pe;
    @JsonProperty("phi")
    private String phi;
    @JsonProperty("plo")
    private String plo;
    @JsonProperty("popn")
    private String popn;
    @JsonProperty("pr_adp_100")
    private String prAdp100;
    @JsonProperty("pr_adp_200")
    private String prAdp200;
    @JsonProperty("pr_adp_50")
    private String prAdp50;
    @JsonProperty("pr_date")
    private String prDate;
    @JsonProperty("pr_openinterest")
    private String prOpeninterest;
    @JsonProperty("prbook")
    private String prbook;
    @JsonProperty("prchg")
    private String prchg;
    @JsonProperty("prem_mult")
    private String premMult;
    @JsonProperty("put_call")
    private String putCall;
    @JsonProperty("pvol")
    private String pvol;
    @JsonProperty("qcond")
    private String qcond;
    @JsonProperty("rootsymbol")
    private String rootsymbol;
    @JsonProperty("secclass")
    private String secclass;
    @JsonProperty("sesn")
    private String sesn;
    @JsonProperty("sho")
    private String sho;
    @JsonProperty("strikeprice")
    private String strikeprice;
    @JsonProperty("symbol")
    private String symbol;
    @JsonProperty("tcond")
    private String tcond;
    @JsonProperty("timestamp")
    private String timestamp;
    @JsonProperty("tr_num")
    private String trNum;
    @JsonProperty("tradetick")
    private String tradetick;
    @JsonProperty("trend")
    private String trend;
    @JsonProperty("under_cusip")
    private String underCusip;
    @JsonProperty("undersymbol")
    private String undersymbol;
    @JsonProperty("vl")
    private String vl;
    @JsonProperty("volatility12")
    private String volatility12;
    @JsonProperty("vwap")
    private String vwap;
    @JsonProperty("wk52hi")
    private String wk52hi;
    @JsonProperty("wk52hidate")
    private String wk52hidate;
    @JsonProperty("wk52lo")
    private String wk52lo;
    @JsonProperty("wk52lodate")
    private String wk52lodate;
    @JsonProperty("xdate")
    private String xdate;
    @JsonProperty("xday")
    private String xday;
    @JsonProperty("xmonth")
    private String xmonth;
    @JsonProperty("xyear")
    private String xyear;
    @JsonProperty("yield")
    private String yield;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("adp_100")
    public String getAdp100() {
        return adp100;
    }

    @JsonProperty("adp_100")
    public void setAdp100(String adp100) {
        this.adp100 = adp100;
    }

    @JsonProperty("adp_200")
    public String getAdp200() {
        return adp200;
    }

    @JsonProperty("adp_200")
    public void setAdp200(String adp200) {
        this.adp200 = adp200;
    }

    @JsonProperty("adp_50")
    public String getAdp50() {
        return adp50;
    }

    @JsonProperty("adp_50")
    public void setAdp50(String adp50) {
        this.adp50 = adp50;
    }

    @JsonProperty("adv_21")
    public String getAdv21() {
        return adv21;
    }

    @JsonProperty("adv_21")
    public void setAdv21(String adv21) {
        this.adv21 = adv21;
    }

    @JsonProperty("adv_30")
    public String getAdv30() {
        return adv30;
    }

    @JsonProperty("adv_30")
    public void setAdv30(String adv30) {
        this.adv30 = adv30;
    }

    @JsonProperty("adv_90")
    public String getAdv90() {
        return adv90;
    }

    @JsonProperty("adv_90")
    public void setAdv90(String adv90) {
        this.adv90 = adv90;
    }

    @JsonProperty("ask")
    public String getAsk() {
        return ask;
    }

    @JsonProperty("ask")
    public void setAsk(String ask) {
        this.ask = ask;
    }

    @JsonProperty("ask_time")
    public String getAskTime() {
        return askTime;
    }

    @JsonProperty("ask_time")
    public void setAskTime(String askTime) {
        this.askTime = askTime;
    }

    @JsonProperty("asksz")
    public String getAsksz() {
        return asksz;
    }

    @JsonProperty("asksz")
    public void setAsksz(String asksz) {
        this.asksz = asksz;
    }

    @JsonProperty("basis")
    public String getBasis() {
        return basis;
    }

    @JsonProperty("basis")
    public void setBasis(String basis) {
        this.basis = basis;
    }

    @JsonProperty("beta")
    public String getBeta() {
        return beta;
    }

    @JsonProperty("beta")
    public void setBeta(String beta) {
        this.beta = beta;
    }

    @JsonProperty("bid")
    public String getBid() {
        return bid;
    }

    @JsonProperty("bid")
    public void setBid(String bid) {
        this.bid = bid;
    }

    @JsonProperty("bid_time")
    public String getBidTime() {
        return bidTime;
    }

    @JsonProperty("bid_time")
    public void setBidTime(String bidTime) {
        this.bidTime = bidTime;
    }

    @JsonProperty("bidsz")
    public String getBidsz() {
        return bidsz;
    }

    @JsonProperty("bidsz")
    public void setBidsz(String bidsz) {
        this.bidsz = bidsz;
    }

    @JsonProperty("bidtick")
    public String getBidtick() {
        return bidtick;
    }

    @JsonProperty("bidtick")
    public void setBidtick(String bidtick) {
        this.bidtick = bidtick;
    }

    @JsonProperty("chg")
    public String getChg() {
        return chg;
    }

    @JsonProperty("chg")
    public void setChg(String chg) {
        this.chg = chg;
    }

    @JsonProperty("chg_sign")
    public String getChgSign() {
        return chgSign;
    }

    @JsonProperty("chg_sign")
    public void setChgSign(String chgSign) {
        this.chgSign = chgSign;
    }

    @JsonProperty("chg_t")
    public String getChgT() {
        return chgT;
    }

    @JsonProperty("chg_t")
    public void setChgT(String chgT) {
        this.chgT = chgT;
    }

    @JsonProperty("cl")
    public String getCl() {
        return cl;
    }

    @JsonProperty("cl")
    public void setCl(String cl) {
        this.cl = cl;
    }

    @JsonProperty("contract_size")
    public String getContractSize() {
        return contractSize;
    }

    @JsonProperty("contract_size")
    public void setContractSize(String contractSize) {
        this.contractSize = contractSize;
    }

    @JsonProperty("cusip")
    public String getCusip() {
        return cusip;
    }

    @JsonProperty("cusip")
    public void setCusip(String cusip) {
        this.cusip = cusip;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("datetime")
    public String getDatetime() {
        return datetime;
    }

    @JsonProperty("datetime")
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @JsonProperty("days_to_expiration")
    public String getDaysToExpiration() {
        return daysToExpiration;
    }

    @JsonProperty("days_to_expiration")
    public void setDaysToExpiration(String daysToExpiration) {
        this.daysToExpiration = daysToExpiration;
    }

    @JsonProperty("div")
    public String getDiv() {
        return div;
    }

    @JsonProperty("div")
    public void setDiv(String div) {
        this.div = div;
    }

    @JsonProperty("divexdate")
    public String getDivexdate() {
        return divexdate;
    }

    @JsonProperty("divexdate")
    public void setDivexdate(String divexdate) {
        this.divexdate = divexdate;
    }

    @JsonProperty("divfreq")
    public String getDivfreq() {
        return divfreq;
    }

    @JsonProperty("divfreq")
    public void setDivfreq(String divfreq) {
        this.divfreq = divfreq;
    }

    @JsonProperty("divpaydt")
    public String getDivpaydt() {
        return divpaydt;
    }

    @JsonProperty("divpaydt")
    public void setDivpaydt(String divpaydt) {
        this.divpaydt = divpaydt;
    }

    @JsonProperty("dollar_value")
    public String getDollarValue() {
        return dollarValue;
    }

    @JsonProperty("dollar_value")
    public void setDollarValue(String dollarValue) {
        this.dollarValue = dollarValue;
    }

    @JsonProperty("eps")
    public String getEps() {
        return eps;
    }

    @JsonProperty("eps")
    public void setEps(String eps) {
        this.eps = eps;
    }

    @JsonProperty("exch")
    public String getExch() {
        return exch;
    }

    @JsonProperty("exch")
    public void setExch(String exch) {
        this.exch = exch;
    }

    @JsonProperty("exch_desc")
    public String getExchDesc() {
        return exchDesc;
    }

    @JsonProperty("exch_desc")
    public void setExchDesc(String exchDesc) {
        this.exchDesc = exchDesc;
    }

    @JsonProperty("hi")
    public String getHi() {
        return hi;
    }

    @JsonProperty("hi")
    public void setHi(String hi) {
        this.hi = hi;
    }

    @JsonProperty("iad")
    public String getIad() {
        return iad;
    }

    @JsonProperty("iad")
    public void setIad(String iad) {
        this.iad = iad;
    }

    @JsonProperty("idelta")
    public String getIdelta() {
        return idelta;
    }

    @JsonProperty("idelta")
    public void setIdelta(String idelta) {
        this.idelta = idelta;
    }

    @JsonProperty("igamma")
    public String getIgamma() {
        return igamma;
    }

    @JsonProperty("igamma")
    public void setIgamma(String igamma) {
        this.igamma = igamma;
    }

    @JsonProperty("imp_volatility")
    public String getImpVolatility() {
        return impVolatility;
    }

    @JsonProperty("imp_volatility")
    public void setImpVolatility(String impVolatility) {
        this.impVolatility = impVolatility;
    }

    @JsonProperty("incr_vl")
    public String getIncrVl() {
        return incrVl;
    }

    @JsonProperty("incr_vl")
    public void setIncrVl(String incrVl) {
        this.incrVl = incrVl;
    }

    @JsonProperty("irho")
    public String getIrho() {
        return irho;
    }

    @JsonProperty("irho")
    public void setIrho(String irho) {
        this.irho = irho;
    }

    @JsonProperty("issue_desc")
    public String getIssueDesc() {
        return issueDesc;
    }

    @JsonProperty("issue_desc")
    public void setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
    }

    @JsonProperty("itheta")
    public String getItheta() {
        return itheta;
    }

    @JsonProperty("itheta")
    public void setItheta(String itheta) {
        this.itheta = itheta;
    }

    @JsonProperty("ivega")
    public String getIvega() {
        return ivega;
    }

    @JsonProperty("ivega")
    public void setIvega(String ivega) {
        this.ivega = ivega;
    }

    @JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }

    @JsonProperty("lo")
    public String getLo() {
        return lo;
    }

    @JsonProperty("lo")
    public void setLo(String lo) {
        this.lo = lo;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("op_delivery")
    public String getOpDelivery() {
        return opDelivery;
    }

    @JsonProperty("op_delivery")
    public void setOpDelivery(String opDelivery) {
        this.opDelivery = opDelivery;
    }

    @JsonProperty("op_flag")
    public String getOpFlag() {
        return opFlag;
    }

    @JsonProperty("op_flag")
    public void setOpFlag(String opFlag) {
        this.opFlag = opFlag;
    }

    @JsonProperty("op_style")
    public String getOpStyle() {
        return opStyle;
    }

    @JsonProperty("op_style")
    public void setOpStyle(String opStyle) {
        this.opStyle = opStyle;
    }

    @JsonProperty("op_subclass")
    public String getOpSubclass() {
        return opSubclass;
    }

    @JsonProperty("op_subclass")
    public void setOpSubclass(String opSubclass) {
        this.opSubclass = opSubclass;
    }

    @JsonProperty("openinterest")
    public String getOpeninterest() {
        return openinterest;
    }

    @JsonProperty("openinterest")
    public void setOpeninterest(String openinterest) {
        this.openinterest = openinterest;
    }

    @JsonProperty("opn")
    public String getOpn() {
        return opn;
    }

    @JsonProperty("opn")
    public void setOpn(String opn) {
        this.opn = opn;
    }

    @JsonProperty("opt_val")
    public String getOptVal() {
        return optVal;
    }

    @JsonProperty("opt_val")
    public void setOptVal(String optVal) {
        this.optVal = optVal;
    }

    @JsonProperty("pchg")
    public String getPchg() {
        return pchg;
    }

    @JsonProperty("pchg")
    public void setPchg(String pchg) {
        this.pchg = pchg;
    }

    @JsonProperty("pchg_sign")
    public String getPchgSign() {
        return pchgSign;
    }

    @JsonProperty("pchg_sign")
    public void setPchgSign(String pchgSign) {
        this.pchgSign = pchgSign;
    }

    @JsonProperty("pcls")
    public String getPcls() {
        return pcls;
    }

    @JsonProperty("pcls")
    public void setPcls(String pcls) {
        this.pcls = pcls;
    }

    @JsonProperty("pe")
    public String getPe() {
        return pe;
    }

    @JsonProperty("pe")
    public void setPe(String pe) {
        this.pe = pe;
    }

    @JsonProperty("phi")
    public String getPhi() {
        return phi;
    }

    @JsonProperty("phi")
    public void setPhi(String phi) {
        this.phi = phi;
    }

    @JsonProperty("plo")
    public String getPlo() {
        return plo;
    }

    @JsonProperty("plo")
    public void setPlo(String plo) {
        this.plo = plo;
    }

    @JsonProperty("popn")
    public String getPopn() {
        return popn;
    }

    @JsonProperty("popn")
    public void setPopn(String popn) {
        this.popn = popn;
    }

    @JsonProperty("pr_adp_100")
    public String getPrAdp100() {
        return prAdp100;
    }

    @JsonProperty("pr_adp_100")
    public void setPrAdp100(String prAdp100) {
        this.prAdp100 = prAdp100;
    }

    @JsonProperty("pr_adp_200")
    public String getPrAdp200() {
        return prAdp200;
    }

    @JsonProperty("pr_adp_200")
    public void setPrAdp200(String prAdp200) {
        this.prAdp200 = prAdp200;
    }

    @JsonProperty("pr_adp_50")
    public String getPrAdp50() {
        return prAdp50;
    }

    @JsonProperty("pr_adp_50")
    public void setPrAdp50(String prAdp50) {
        this.prAdp50 = prAdp50;
    }

    @JsonProperty("pr_date")
    public String getPrDate() {
        return prDate;
    }

    @JsonProperty("pr_date")
    public void setPrDate(String prDate) {
        this.prDate = prDate;
    }

    @JsonProperty("pr_openinterest")
    public String getPrOpeninterest() {
        return prOpeninterest;
    }

    @JsonProperty("pr_openinterest")
    public void setPrOpeninterest(String prOpeninterest) {
        this.prOpeninterest = prOpeninterest;
    }

    @JsonProperty("prbook")
    public String getPrbook() {
        return prbook;
    }

    @JsonProperty("prbook")
    public void setPrbook(String prbook) {
        this.prbook = prbook;
    }

    @JsonProperty("prchg")
    public String getPrchg() {
        return prchg;
    }

    @JsonProperty("prchg")
    public void setPrchg(String prchg) {
        this.prchg = prchg;
    }

    @JsonProperty("prem_mult")
    public String getPremMult() {
        return premMult;
    }

    @JsonProperty("prem_mult")
    public void setPremMult(String premMult) {
        this.premMult = premMult;
    }

    @JsonProperty("put_call")
    public String getPutCall() {
        return putCall;
    }

    @JsonProperty("put_call")
    public void setPutCall(String putCall) {
        this.putCall = putCall;
    }

    @JsonProperty("pvol")
    public String getPvol() {
        return pvol;
    }

    @JsonProperty("pvol")
    public void setPvol(String pvol) {
        this.pvol = pvol;
    }

    @JsonProperty("qcond")
    public String getQcond() {
        return qcond;
    }

    @JsonProperty("qcond")
    public void setQcond(String qcond) {
        this.qcond = qcond;
    }

    @JsonProperty("rootsymbol")
    public String getRootsymbol() {
        return rootsymbol;
    }

    @JsonProperty("rootsymbol")
    public void setRootsymbol(String rootsymbol) {
        this.rootsymbol = rootsymbol;
    }

    @JsonProperty("secclass")
    public String getSecclass() {
        return secclass;
    }

    @JsonProperty("secclass")
    public void setSecclass(String secclass) {
        this.secclass = secclass;
    }

    @JsonProperty("sesn")
    public String getSesn() {
        return sesn;
    }

    @JsonProperty("sesn")
    public void setSesn(String sesn) {
        this.sesn = sesn;
    }

    @JsonProperty("sho")
    public String getSho() {
        return sho;
    }

    @JsonProperty("sho")
    public void setSho(String sho) {
        this.sho = sho;
    }

    @JsonProperty("strikeprice")
    public String getStrikeprice() {
        return strikeprice;
    }

    @JsonProperty("strikeprice")
    public void setStrikeprice(String strikeprice) {
        this.strikeprice = strikeprice;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @JsonProperty("tcond")
    public String getTcond() {
        return tcond;
    }

    @JsonProperty("tcond")
    public void setTcond(String tcond) {
        this.tcond = tcond;
    }

    @JsonProperty("timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    @JsonProperty("timestamp")
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("tr_num")
    public String getTrNum() {
        return trNum;
    }

    @JsonProperty("tr_num")
    public void setTrNum(String trNum) {
        this.trNum = trNum;
    }

    @JsonProperty("tradetick")
    public String getTradetick() {
        return tradetick;
    }

    @JsonProperty("tradetick")
    public void setTradetick(String tradetick) {
        this.tradetick = tradetick;
    }

    @JsonProperty("trend")
    public String getTrend() {
        return trend;
    }

    @JsonProperty("trend")
    public void setTrend(String trend) {
        this.trend = trend;
    }

    @JsonProperty("under_cusip")
    public String getUnderCusip() {
        return underCusip;
    }

    @JsonProperty("under_cusip")
    public void setUnderCusip(String underCusip) {
        this.underCusip = underCusip;
    }

    @JsonProperty("undersymbol")
    public String getUndersymbol() {
        return undersymbol;
    }

    @JsonProperty("undersymbol")
    public void setUndersymbol(String undersymbol) {
        this.undersymbol = undersymbol;
    }

    @JsonProperty("vl")
    public String getVl() {
        return vl;
    }

    @JsonProperty("vl")
    public void setVl(String vl) {
        this.vl = vl;
    }

    @JsonProperty("volatility12")
    public String getVolatility12() {
        return volatility12;
    }

    @JsonProperty("volatility12")
    public void setVolatility12(String volatility12) {
        this.volatility12 = volatility12;
    }

    @JsonProperty("vwap")
    public String getVwap() {
        return vwap;
    }

    @JsonProperty("vwap")
    public void setVwap(String vwap) {
        this.vwap = vwap;
    }

    @JsonProperty("wk52hi")
    public String getWk52hi() {
        return wk52hi;
    }

    @JsonProperty("wk52hi")
    public void setWk52hi(String wk52hi) {
        this.wk52hi = wk52hi;
    }

    @JsonProperty("wk52hidate")
    public String getWk52hidate() {
        return wk52hidate;
    }

    @JsonProperty("wk52hidate")
    public void setWk52hidate(String wk52hidate) {
        this.wk52hidate = wk52hidate;
    }

    @JsonProperty("wk52lo")
    public String getWk52lo() {
        return wk52lo;
    }

    @JsonProperty("wk52lo")
    public void setWk52lo(String wk52lo) {
        this.wk52lo = wk52lo;
    }

    @JsonProperty("wk52lodate")
    public String getWk52lodate() {
        return wk52lodate;
    }

    @JsonProperty("wk52lodate")
    public void setWk52lodate(String wk52lodate) {
        this.wk52lodate = wk52lodate;
    }

    @JsonProperty("xdate")
    public String getXdate() {
        return xdate;
    }

    @JsonProperty("xdate")
    public void setXdate(String xdate) {
        this.xdate = xdate;
    }

    @JsonProperty("xday")
    public String getXday() {
        return xday;
    }

    @JsonProperty("xday")
    public void setXday(String xday) {
        this.xday = xday;
    }

    @JsonProperty("xmonth")
    public String getXmonth() {
        return xmonth;
    }

    @JsonProperty("xmonth")
    public void setXmonth(String xmonth) {
        this.xmonth = xmonth;
    }

    @JsonProperty("xyear")
    public String getXyear() {
        return xyear;
    }

    @JsonProperty("xyear")
    public void setXyear(String xyear) {
        this.xyear = xyear;
    }

    @JsonProperty("yield")
    public String getYield() {
        return yield;
    }

    @JsonProperty("yield")
    public void setYield(String yield) {
        this.yield = yield;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
