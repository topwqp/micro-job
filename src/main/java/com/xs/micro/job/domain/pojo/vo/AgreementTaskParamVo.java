package com.xs.micro.job.domain.pojo.vo;

import java.io.Serializable;

/**
 * 合同管理task参数
 * @author guochaohui
 */
public class AgreementTaskParamVo implements Serializable {

    private String dataIds;
    private String dataYear;
    private String StartDateTime;
    private String endDateTime;
    private String batchNo;

    public String getDataIds() {
        return dataIds;
    }

    public void setDataIds(String dataIds) {
        this.dataIds = dataIds;
    }

    public String getDataYear() {
        return dataYear;
    }

    public void setDataYear(String dataYear) {
        this.dataYear = dataYear;
    }

    public String getStartDateTime() {
        return StartDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        StartDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }

}
