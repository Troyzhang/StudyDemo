package com.troy.randomForest;

import java.text.MessageFormat;

/**
 * Created by zhangyongyu on 2016/12/7.
 *
 * @parse com.troy.randomForest
 */
public class Client {
    public static void main(String[] args) {
        String filePath = "/Users/zhangyongyu/Workprojects/troyStudy/StudyDemo/src/main/resources/datong.txt";
        String queryStr = "Age=Youth,Income=Low,Student=No,CreditRating=Fair";
        String resultClassType = "";
        // 决策树的样本占总数的占比率
        double sampleNumRatio = 0.4;
        // 样本数据的采集特征数量占总特征的比例
        double featureNumRatio = 0.5;

        RandomForestTool tool = new RandomForestTool(filePath, sampleNumRatio, featureNumRatio);
        tool.constructRandomTree();

        resultClassType = tool.judgeClassType(queryStr);

        System.out.println();
        System.out.println(MessageFormat.format("查询属性描述{0},预测的分类结果为BuysCompute:{1}",
                queryStr, resultClassType));
    }
}
