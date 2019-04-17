package logAnly;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

public class AnalysisHandler {

    /**
     * 分析源dta的耗时
     */
    public static ScenarioResult getSvrResult(String svrName, String logFilePath, String phase) throws Exception {
        ScenarioResult sr = new ScenarioResult();
        sr.setSvrName(svrName);
        List<LogBean> allLogBean= LogFileHandler.getAllLogInfoBy("", logFilePath);
        List<LogBean> phaseLogBeans = new ArrayList<>(allLogBean.size()/2);
        LogBean lbTemp = null;
        for (int i = 0; i < allLogBean.size(); i++) {
            lbTemp = allLogBean.get(i);
            if (phase.equals(lbTemp.getPhaseCode())){
                if (svrName.equals(lbTemp.getSvrName()) || "null".equals(lbTemp.getSvrName())) {
                    phaseLogBeans.add(lbTemp);
                }
            }
        }

        System.out.println("符合" + phase + "的日志总数：" + phaseLogBeans.size());

        Map<Double, Integer> timeMap = new HashMap<>();
        double tempTime = 0.00D;
        double timeSum = 0.00D;
        int index = 0;
        double[] timeArr = new double[phaseLogBeans.size()];
        int matchIndex = -1;
        long start = System.currentTimeMillis();
        for (int j = 0; j < phaseLogBeans.size(); j++) {
            if (j == matchIndex) {
                continue;
            }
            if (phaseLogBeans.get(j).getSvrName().equals(svrName)) {
                for (int l = 0; l < phaseLogBeans.size(); l++) {
                    if (l == j) {
                        continue;
                    }
                    if (phaseLogBeans.get(j).getSeqNo().equals(phaseLogBeans.get(l).getSeqNo())) {
                        matchIndex = l;
//                        System.out.println(phaseLogBeans.get(j).toString());
                        tempTime = Math.abs(phaseLogBeans.get(j).getDate().getTime() - phaseLogBeans.get(l).getDate().getTime());
                        timeSum += tempTime;
//                        System.out.println("" + index + ":" + tempTime);
                        timeArr[index] = tempTime;
                        timeMap.put(tempTime, j);
                        index ++;
                        break;
                    }
                }
            }
        }
        double[] actualArr = new double[index];
        System.out.println("分析共耗时：" + (System.currentTimeMillis() - start) + "ms");
        System.arraycopy(timeArr, 0, actualArr, 0, index);
        Arrays.sort(actualArr);
//        System.out.println(Arrays.toString(actualArr));

        sr.setCount(index);
        sr.setAverageTime(timeSum/index);
        sr.setMaxTime(actualArr[actualArr.length-1]);
        sr.setMinTime(actualArr[0]);
        System.out.println("最大耗时:" + phaseLogBeans.get(timeMap.get(actualArr[actualArr.length - 1])).toString());
        System.out.println("最小耗时:" + phaseLogBeans.get(timeMap.get(actualArr[0])).toString());
        return sr;
    }

    /**
     * 分析业务处理Ala的时间
     */
    public static ScenarioResult getAlaResult(String svrName, String logFilePath) throws Exception {
        ScenarioResult sr = new ScenarioResult();
        sr.setSvrName(svrName);
        List<LogBean> allLogBean= LogFileHandler.getAllLogInfoBy(svrName, logFilePath);
        double timeSum = 0.00D;
        int countSum = 0;
        double temp = 0.00D;
        double[] timeArr = new double[(int)Math.floor(allLogBean.size()/2)];
        LogBean lbj = null;
        LogBean lbi = null;
        long start = System.currentTimeMillis();
        int matchIndex = -1;
        Map<Double, Integer> timeMap = new HashMap<>();

        for(int i=0; i<allLogBean.size(); i++) {
            if (matchIndex == i) {
                continue;
            }
            lbi = allLogBean.get(i);

            for(int j=i+1; j<allLogBean.size(); j++) {
                lbj = allLogBean.get(j);
                if (lbi.getSeqNo().equals(lbj.getSeqNo())
                        && lbi.getPhaseCode().equals(lbj.getPhaseCode())) {
                    temp = Math.abs(lbi.getDate().getTime() - lbj.getDate().getTime());
                    timeSum += temp;
                    timeArr[countSum] = temp;
                    countSum ++;
//                    System.out.println("第" + countSum + "次耗时：" + temp);
                    timeMap.put(temp, i);
                    matchIndex = j;
                    break;
                }
            }
        }
        System.out.println("分析共耗时：" + (System.currentTimeMillis() - start) + "ms");
        Arrays.sort(timeArr);

//        sr.setTimeMap(timeMap);
        sr.setCount(countSum);
        sr.setAverageTime(timeSum/countSum);
        sr.setMaxTime(timeArr[timeArr.length-1]);
        System.out.println("最大耗时:" + allLogBean.get(timeMap.get(timeArr[timeArr.length - 1])).toString());
        sr.setMinTime(timeArr[0]);
        System.out.println("最小耗时:" + allLogBean.get(timeMap.get(timeArr[0])).toString());

        return sr;
    }

    public static void analysisSeqAndDate(String svrName, String  logFilePath) throws Exception {
        List<LogBean> allLogBean= LogFileHandler.getAllLogInfoBy(svrName, logFilePath);
        BigDecimal[] arr = new BigDecimal[allLogBean.size()];
        Map<String, Date> map = new HashMap<>(allLogBean.size());
        for (int i = 0; i < allLogBean.size(); i++) {
            arr[i] = new BigDecimal(allLogBean.get(i).getSeqNo());
            map.put(arr[i].toPlainString(), allLogBean.get(i).getDate());
        }

        Arrays.sort(arr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SS");

        for (int j = 0; j < arr.length; ) {
            System.out.println(arr[j].toPlainString() + "------>" + sdf.format(map.get(arr[j].toPlainString())).toString());
            j+=4;
        }
    }
    public static void main(String[] args) throws Exception {
        String logFilePath = "C:\\Users\\Admin\\Desktop\\temp\\333";
        ScenarioResult sr = getAlaResult("CBS0000030", logFilePath);
        System.out.println(sr);
        System.out.println();

//        logFilePath = "C:\\Users\\Admin\\Desktop\\temp\\all";
//        sr = getSvrResult("CBSMPS0080", logFilePath, "ibpsnsvr");
//        System.out.println(sr);
//        System.out.println();

    }
}
