package com.novg.reportmg;

import java.util.AbstractCollection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by NovgorodskiyAK on 13.01.2016.
 */
public class Initializer {
    static int[] getMvzGts() {
        int[] mvzGts = {
                0, 530100000, 530200000, 530202000, 530204020,
                530300000, 530300010, 530300040, 530600000, 530600010,
                530600020, 530600030, 530600040, 530601000, 530700000,
                530700010, 530700020, 530700030, 530700040, 530700070,
                530701000, 530701010, 530702000, 530800000, 530800010,
                530800020, 530800030, 530800050, 530800060, 530800070,
                530800080, 530900000, 530900010, 530900020, 530900030,
                530901000, 531100000, 531100010, 531100020, 531100030,
                531100050, 531100060, 531101020, 531100070, 531200000,
                531200010, 531200020, 531200040, 531200050, 531300010,
                531300020, 531300100, 531700000, 531701000, 531702000,
                531703000, 531800040, 531900000, 531910000, 531910020,
                530700090,
        };

        return mvzGts;
    }

    static int[] getMvzRtk() {
        int[] mvzRtk = {
                0, 530100000, 530200000, 530202000, 530300000,
                530300010, 530300040, 530600000, 530600010, 530600020,
                530600030, 530600040, 530601000, 530700000, 530700010,
                530700020, 530700030, 530700040, 530700070, 530701000,
                530701010, 530702000, 530800000, 530800010, 530800020,
                530800030, 530800050, 530800060, 530800070, 530800080,
                530900000, 530900010, 530900020, 530900030, 530901000,
                530902000, 531100000, 531100010, 531100020, 531100030,
                531100060, 531101020, 531100070, 531200000, 531200010,
                531200020, 531200040, 531200050, 531300010, 531300020,
                531700000, 531701000, 531702000, 531703000, 531800040,
                531900000, 531910000, 531910020, 530700090,

        };
        return mvzRtk;
    }

    static String[] getMvzCaption() {
        String[] caption = {"МВЗ", "Заказ", "Сумма по МВЗ"};
        return caption;
    }

    static String[] getStatisticCaption() {
        String[] caption = {"Дата", "Время", "Город", "Абонент", "Мин", "Сумма", "Код", "Выз_телефон", "МВЗ", "Заказ"};
        return caption;
    }

    static String[] getMvzPhoneCaption() {
        String[] caption = {"№ телефона", "Наименование заказа"};
        return caption;
    }

    static Map<String, String> getMvzPhoneMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("20266", "531200000");
        map.put("20356", "531200020");
        map.put("20600", "531200000");
        map.put("20673", "0");
        map.put("21101", "531200000");
        map.put("21529", "531200000");
        map.put("21956", "531300050");
        map.put("22054", "530600000");
        map.put("22800", "531300040");
        map.put("23122", "530702000");
        map.put("23133", "531100010");
        map.put("23144", "531100010");
        map.put("23510", "531300050");
        map.put("24377", "531300100");
        map.put("26092", "530800000");
        map.put("26138", "530702000");
        map.put("26488", "531200000");
        map.put("62267", "531200040");
        map.put("63445", "531100050");
        map.put("63644", "531200000");
        map.put("73004", "530600030");
        map.put("73006", "530600010");
        map.put("73027", "530600010");
        map.put("73038", "530800030");
        map.put("73040", "530900020");
        map.put("73050", "531300020");
        map.put("73068", "531100010");
        map.put("73107", "531100010");
        map.put("73167", "530600030");
        map.put("73180", "531100010");
        map.put("73211", "530601000");
        map.put("73237", "530600020");
        map.put("73238", "530700070");
        map.put("73263", "530800030");
        map.put("73267", "530600010");
        map.put("73287", "530600000");
        map.put("73317", "530600010");
        map.put("73318", "530600040");
        map.put("73320", "530800030");
        map.put("73321", "530600010");
        map.put("73347", "531200020");
        map.put("73368", "531200010");
        map.put("73372", "530600000");
        map.put("73380", "531200050");
        map.put("73441", "530700000");
        map.put("73456", "530100000");
        map.put("73512", "530600010");
        map.put("73522", "530600010");
        map.put("73531", "531100020");
        map.put("73570", "531910000");
        map.put("73571", "531910000");
        map.put("73582", "531910000");
        map.put("73602", "530800030");
        map.put("73611", "531200010");
        map.put("73666", "530200000");
        map.put("73680", "531200000");
        map.put("73684", "531100010");
        map.put("73704", "530600010");
        map.put("73790", "531200040");
        map.put("73801", "530800000");
        map.put("73810", "530800000");
        map.put("73820", "");
        map.put("73822", "530600010");
        map.put("73828", "530600010");
        map.put("73831", "530600010");
        map.put("73860", "531100010");
        map.put("73872", "531200000");
        map.put("73881", "");
        map.put("73901", "531100030");
        map.put("73903", "530700090");
        map.put("73905", "531200000");
        map.put("73923", "530600000");
        map.put("73950", "531100000");
        map.put("73960", "531100010");
        map.put("73961", "530601000");
        map.put("73966", "530600040");
        map.put("77090", "530300000");
        map.put("77117", "531200130");
        map.put("77121", "531100010");
        map.put("77154", "530600040");
        map.put("77168", "530800010");
        map.put("77197", "530800030");
        map.put("77269", "530800050");
        map.put("77296", "530601000");
        map.put("77331", "530800030");
        map.put("77372", "530300000");
        map.put("77401", "531200000");
        map.put("77405", "531200040");
        map.put("77423", "531200010");
        map.put("77431", "531200000");
        map.put("77465", "530202000");
        map.put("77531", "531100010");
        map.put("77552", "530700000");
        map.put("77555", "530600010");
        map.put("77710", "531200000");
        map.put("77765", "530700030");
        map.put("77830", "530300000");
        map.put("77843", "531200000");
        map.put("77856", "530900000");
        map.put("77867", "531100010");
        map.put("77981", "531100010");
        map.put("77989", "531200000");
        map.put("77988", "530800000");
        map.put("77991", "530700000");
        map.put("77996", "531200010");
        map.put("79925", "530200000");
        map.put("79932", "531200000");
        map.put("79933", "531200000");
        map.put("79945", "530701000");
        return map;
    }

    static String[] getMvzOrderCaption() {
        String[] caption = {"Наименование заказа", "№ заказа"};
        return caption;
    }

    static Map<String, String> getMvzOrderMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("0", "");
        map.put("530100000", "538090000013");
        map.put("530100010", "538090000015");
        map.put("530100020", "538090000014");
        map.put("530200000", "538090000016");
        map.put("530202000", "538090000017");
        map.put("530202010", "538090000018");
        map.put("530203010", "538090000019");
        map.put("530300000", "538090000020");
        map.put("530300010", "538090000021");
        map.put("530300020", "538090000022");
        map.put("530300040", "538090000023");
        map.put("530301010", "538090000024");
        map.put("530600000", "538090000025");
        map.put("530600010", "538090000030");
        map.put("530600030", "538090000027");
        map.put("530600040", "538090000029");
        map.put("530600050", "538090000026");
        map.put("530600060", "538090000028");
        map.put("530601000", "");
        map.put("530700000", "538090000031");
        map.put("530700020", "538090000032");
        map.put("530700030", "538090000033");
        map.put("530700040", "538090000034");
        map.put("530700060", "538090000035");
        map.put("530700090", "");
        map.put("530701000", "538090000036");
        map.put("530701020", "538090000037");
        map.put("530800000", "538090000038");
        map.put("530800010", "538090000042");
        map.put("530800020", "538090000041");
        map.put("530800030", "538090000054");
        map.put("530800050", "");
        map.put("530800070", "538090000039");
        map.put("530800090", "538090000040");
        map.put("530900020", "538090000043");
        map.put("530900030", "538090000043");
        map.put("531100000", "538090000044");
        map.put("531100010", "538090000045");
        map.put("531100020", "538090000046");
        map.put("531100030", "");
        map.put("531100060", "");
        map.put("531100070", "");
        map.put("531101020", "");
        map.put("531200000", "538090000047");
        map.put("531200010", "538090000048");
        map.put("531200020", "");
        map.put("531200040", "538090000049");
        map.put("531200050", "");
        map.put("531300020", "");
        map.put("531800000", "538090000050");
        map.put("531800020", "538090000051");
        map.put("531800030", "538090000052");
        map.put("531910000", "");
        map.put("531910010", "538090000053");
        map.put("999999999", "");
        return map;
    }

    static String[] getCorporateCaption() {
        String[] caption = {"№ телефона", "Категория"};
        return caption;
    }

    static Map<String, String> getCorporateMap() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("73380", "6");
        map.put("73582", "6");
        map.put("77121", "6");
        map.put("73040", "2");
        map.put("73050", "2");
        map.put("73107", "2");
        map.put("73211", "9");
        map.put("73263", "9");
        map.put("73321", "4");
        map.put("73372", "4");
        map.put("73441", "2");
        map.put("73570", "2");
        map.put("73571", "2");
        map.put("73602", "2");
        map.put("73611", "2");
        map.put("73666", "4");
        map.put("73801", "2");
        map.put("73868", "4");
        map.put("73872", "2");
        map.put("73881", "2");
        map.put("73905", "4");
        map.put("73961", "2");
        map.put("77117", "2");
        map.put("77197", "2");
        map.put("77269", "2");
        map.put("77296", "2");
        map.put("77331", "9");
        map.put("77372", "4");
        map.put("77710", "4");
        map.put("77765", "2");
        map.put("77867", "9");
        map.put("73004", "4");
        map.put("73006", "4");
        map.put("73027", "2");
        map.put("73068", "9");
        map.put("73167", "2");
        map.put("73180", "9");
        map.put("73237", "2");
        map.put("73267", "4");
        map.put("73287", "4");
        map.put("73317", "4");
        map.put("73318", "4");
        map.put("73320", "2");
        map.put("73347", "16");
        map.put("73368", "2");
        map.put("73371", "9");
        map.put("73456", "4");
        map.put("73512", "4");
        map.put("73522", "9");
        map.put("73531", "9");
        map.put("73680", "4");
        map.put("73684", "4");
        map.put("73704", "4");
        map.put("73790", "2");
        map.put("73810", "2");
        map.put("73820", "4");
        map.put("73822", "4");
        map.put("73828", "4");
        map.put("73831", "4");
        map.put("73901", "2");
        map.put("73903", "2");
        map.put("73923", "4");
        map.put("73950", "4");
        map.put("73960", "9");
        map.put("73966", "4");
        map.put("77090", "2");
        map.put("77154", "2");
        map.put("77168", "2");
        map.put("77401", "4");
        map.put("77405", "2");
        map.put("77423", "2");
        map.put("77431", "4");
        map.put("77465", "4");
        map.put("77531", "2");
        map.put("77552", "4");
        map.put("77555", "4");
        map.put("77830", "2");
        map.put("77843", "4");
        map.put("77856", "4");
        map.put("77981", "9");
        map.put("77988", "2");
        map.put("77991", "4");
        map.put("77996", "2");
        map.put("79925", "2");
        map.put("79932", "4");
        map.put("79933", "4");
        map.put("79945", "2");

        return map;
    }
}
