package com.xs.micro.job.domain.task;

import com.xiangshang.elasticjob.lite.starter.annotation.ElasticSimpleJob;
import com.xs.micro.job.domain.pojo.em.AgreementTaskType;
import com.xs.micro.job.domain.pojo.vo.AgreementTaskParamVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合同协议签章申请task
 *
 * @author guochaohui
 */
@ElasticSimpleJob(
        appName = "${spring.application.name}",
        jobClass = AgreementSignApplyTask.class,
        cron = "5 * * * * ?",
        shardingTotalCount = "2",
        description = "合同协议微服务-签章申请定时",
        needWarn = false,
        warnMobiles = {"13534523334"}
)
@Service("agreementSignApplyTask")
public class AgreementSignApplyTask extends AbstractAgreementMultipleTask {


    @Override
    AgreementTaskType taskType() {
        return AgreementTaskType.SIGN_APPLY;
    }

    @Override
    void doBusiness(int dataId, AgreementTaskParamVo agreementTaskParamVo) {
        LOG.info("AgreementSignApplyTask start ..........xxxxxxxxxxxxx......");
    }

    @Override
    int querySingleMaxCount() {
        return 0;
    }

    @Override
    long lockAcquireSeconds() {
        return 0;
    }

    @Override
    List<Integer> getDataIdList(int queryMaxCount, AgreementTaskParamVo agreementTaskParamVo) {
        return null;
    }

    @Override
    boolean isAutoRunTask() {
        return true;
    }
}
