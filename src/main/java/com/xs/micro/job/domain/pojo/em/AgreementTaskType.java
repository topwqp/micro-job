package com.xs.micro.job.domain.pojo.em;


/**
 * 协议签章任务类型
 *
 * @author guochaohui
 */
public enum AgreementTaskType  {
    //
    SIGN_APPLY(1, "签章申请任务", "AgreementSignApplyTask"),
    FILE_INIT(2, "签章文件信息初始化任务", "AgreementFileInfoInitTask"),
    FILE_SIGN_CURRENT_YEAR(3, "签章文件盖章任务", "AgreementFileSignCurrentYearTask"),
    FILE_SIGN_PREVIOUS_YEAR(4, "签章文件盖章任务", "AgreementFileSignPreviousYearTask"),
    FILE_EXIST(5, "校验签章文件是否存在任务", "AgreementCheckSignFileExistTask"),
    FILE_UPLOAD(6, "签章文件上传任务", "AgreementFileUploadTask"),
    BATCH_DOWNLOAD(7, "批量文件下载", "AgreementBatchDownloadTask"),
    ;

    private AgreementTaskType(int value, String desc, String descEnglish) {
        this.value = value;
        this.desc = desc;
        this.descEnglish = descEnglish;
    }

    private int value;

    private String desc;

    private String descEnglish;

    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public String getDescEnglish() {
        return descEnglish;
    }

    @Override
    public String toString() {
        return desc;
    }

    public int intValue() {
        return value;
    }


}
