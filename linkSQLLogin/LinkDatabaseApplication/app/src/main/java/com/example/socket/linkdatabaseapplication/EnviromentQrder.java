package com.example.socket.linkdatabaseapplication;

public class EnviromentQrder {
    private String count;
    private String state;//订单状态
    private String client;//客户
    private String factory;//工厂
    private String num;//制令单号
    private String record;//订单临时变更
    private String coding;//产品编号
    private String cilentID;//客户编号
    private String model;//客户机型
    private String logo;//LOGO
    private String proname;//工厂机型
    private String range;//量程精度
    private String unit;//称重单位
    private String reunit;//断电开机
    private String memunit;//记忆单位
    private String frames;//开机画面
    private String backcolor;//背光颜色
    private String closetime;//关机时间
    private String backtime;//背光时间
    private String revise;//校机砝码
    private String cleRange;//自有程序
    private String cleShutdowm;//内配功能
    private String gravity;//内配重力加速度功能
    private String levFacSet;//出厂标准
    private String cell;//电池
    private String plastic;//塑胶颜色
    private String quantity;//订单数量
    private String delivery;//交货日期
    private String encase;//装箱方式
    private String box;//箱唛
    private String ask;//客户细节要求
    private String bomVerify;//物料需求提交状态
    private String starv;//报缺情况
    private String oliquan;//喷油丝印
    private String elequan;//委外电镀
    private String elsequan;//其他委外
    private String facAlter;//厂发变更记录
    private String fristMake;//首件制作
    private String fristChk;//首件确认
    private String proSum;//生产问题汇总
    private String spotChk;//成品问题汇总
    private String out;//出货操作
    private String finish;//结单操作


    public EnviromentQrder(String count,String state, String client, String factory, String num, String record, String coding, String cilentID, String model, String logo, String proname, String range, String unit, String reunit, String memunit, String frames, String backcolor, String closetime, String backtime, String revise, String cleRange, String cleShutdowm, String gravity, String levFacSet, String cell, String plastic, String quantity, String delivery, String encase, String box, String ask, String bomVerify, String starv, String oliquan, String elequan, String elsequan, String facAlter, String fristMake, String fristChk, String proSum, String spotChk, String out, String finish) {
        this.count = count;
        this.state = state;
        this.client = client;
        this.factory = factory;
        this.num = num;
        this.record = record;
        this.coding = coding;
        this.cilentID = cilentID;
        this.model = model;
        this.logo = logo;
        this.proname = proname;
        this.range = range;
        this.unit = unit;
        this.reunit = reunit;
        this.memunit = memunit;
        this.frames = frames;
        this.backcolor = backcolor;
        this.closetime = closetime;
        this.backtime = backtime;
        this.revise = revise;
        this.cleRange = cleRange;
        this.cleShutdowm = cleShutdowm;
        this.gravity = gravity;
        this.levFacSet = levFacSet;
        this.cell = cell;
        this.plastic = plastic;
        this.quantity = quantity;
        this.delivery = delivery;
        this.encase = encase;
        this.box = box;
        this.ask = ask;
        this.bomVerify = bomVerify;
        this.starv = starv;
        this.oliquan = oliquan;
        this.elequan = elequan;
        this.elsequan = elsequan;
        this.facAlter = facAlter;
        this.fristMake = fristMake;
        this.fristChk = fristChk;
        this.proSum = proSum;
        this.spotChk = spotChk;
        this.out = out;
        this.finish = finish;
    }
    public String getCount()
    {
        return count;
    }
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

    public String getCilentID() {
        return cilentID;
    }

    public void setCilentID(String cilentID) {
        this.cilentID = cilentID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReunit() {
        return reunit;
    }

    public void setReunit(String reunit) {
        this.reunit = reunit;
    }

    public String getMemunit() {
        return memunit;
    }

    public void setMemunit(String memunit) {
        this.memunit = memunit;
    }

    public String getFrames() {
        return frames;
    }

    public void setFrames(String frames) {
        this.frames = frames;
    }

    public String getBackcolor() {
        return backcolor;
    }

    public void setBackcolor(String backcolor) {
        this.backcolor = backcolor;
    }

    public String getClosetime() {
        return closetime;
    }

    public void setClosetime(String closetime) {
        this.closetime = closetime;
    }

    public String getBacktime() {
        return backtime;
    }

    public void setBacktime(String backtime) {
        this.backtime = backtime;
    }

    public String getRevise() {
        return revise;
    }

    public void setRevise(String revise) {
        this.revise = revise;
    }

    public String getCleRange() {
        return cleRange;
    }

    public void setCleRange(String cleRange) {
        this.cleRange = cleRange;
    }

    public String getCleShutdowm() {
        return cleShutdowm;
    }

    public void setCleShutdowm(String cleShutdowm) {
        this.cleShutdowm = cleShutdowm;
    }

    public String getGravity() {
        return gravity;
    }

    public void setGravity(String gravity) {
        this.gravity = gravity;
    }

    public String getLevFacSet() {
        return levFacSet;
    }

    public void setLevFacSet(String levFacSet) {
        this.levFacSet = levFacSet;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public String getPlastic() {
        return plastic;
    }

    public void setPlastic(String plastic) {
        this.plastic = plastic;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public String getEncase() {
        return encase;
    }

    public void setEncase(String encase) {
        this.encase = encase;
    }

    public String getBox() {
        return box;
    }

    public void setBox(String box) {
        this.box = box;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getBomVerify() {
        return bomVerify;
    }

    public void setBomVerify(String bomVerify) {
        this.bomVerify = bomVerify;
    }

    public String getStarv() {
        return starv;
    }

    public void setStarv(String starv) {
        this.starv = starv;
    }

    public String getOliquan() {
        return oliquan;
    }

    public void setOliquan(String oliquan) {
        this.oliquan = oliquan;
    }

    public String getElequan() {
        return elequan;
    }

    public void setElequan(String elequan) {
        this.elequan = elequan;
    }

    public String getElsequan() {
        return elsequan;
    }

    public void setElsequan(String elsequan) {
        this.elsequan = elsequan;
    }

    public String getFacAlter() {
        return facAlter;
    }

    public void setFacAlter(String facAlter) {
        this.facAlter = facAlter;
    }

    public String getFristMake() {
        return fristMake;
    }

    public void setFristMake(String fristMake) {
        this.fristMake = fristMake;
    }

    public String getFristChk() {
        return fristChk;
    }

    public void setFristChk(String fristChk) {
        this.fristChk = fristChk;
    }

    public String getProSum() {
        return proSum;
    }

    public void setProSum(String proSum) {
        this.proSum = proSum;
    }

    public String getSpotChk() {
        return spotChk;
    }

    public void setSpotChk(String spotChk) {
        this.spotChk = spotChk;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }
    public EnviromentQrder(String s, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10, String s11, String s12, String s13, String s14, String s15, String s16, String s17, String s18, String s19, String s20, String s21, String s22, String s23, String s24, String s25, String s26, String s27, String s28, String s29, String s30, String s31, String s32, String s33, String s34, String s35, String s36, String s37, String s38, String s39) {

    }
}
