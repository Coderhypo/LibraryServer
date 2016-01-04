package net.ihypo.models;

import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 * 借阅日志类，与数据库中lend_log表对应
 * Created by hypo on 15-12-26.
 */
public class LendLog {

    private Integer lendId;
    private Integer bookId;
    private Integer userId;
    private Date lendTime;
    private Date deadlineTime;
    private Date returnTime;

    /**
     * 一个读者可以借阅的最长时间为30天,超过该时间将要缴纳罚金
     */
    private static final Long MAXLENDTIME = DateUtils.MILLIS_PER_DAY * 30;

    /**
     * 如果超期每日的罚金 每日0.2元
     */
    private static final Double DAYFINE = 0.2;

    public LendLog(Integer bookId, Integer userId) {
        this.bookId = bookId;
        this.userId = userId;
        this.lendTime = new Date();
        this.returnTime = null;
        this.deadlineTime = new Date(this.lendTime.getTime() + MAXLENDTIME);
    }

    public LendLog() {
    }

    /**
     * 查看图书是否归还
     * @return true为已经归还 | false为未归还
     */
    public Boolean isReturn(){
        if (this.returnTime != null){
            return true;
        }

        return false;
    }

    /**
     * 归还图书方法 并更新用户罚金总额
     * @return 返回用户目前罚金欠款累计总额
     */
    public Double returnBook(){

        // 获得当前借阅应该缴纳的罚金
        Double fine = getDebt();

        //归还图书
        setReturnTime();

        return fine;
    }

    /**
     * 计算图书罚金
     * @return 到目前为止应该缴纳的罚金
     */

    public Double getDebt(){

        Double fine = 0.0;

        Long moreTime = this.returnTime.getTime() - this.deadlineTime.getTime();

        if(moreTime > 0){
            int dayNum = (int) (moreTime / DateUtils.MILLIS_PER_DAY);
            fine = DAYFINE * dayNum;
        }

        return fine;
    }

    public Integer getBookId() {
        return bookId;
    }

    public Date getDeadlineTime() {
        return deadlineTime;
    }

    public Integer getLendId() {
        return lendId;
    }

    public Date getLendTime() {
        return lendTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public Integer getUserId() {
        return userId;
    }

    private void setReturnTime() {
        this.returnTime = new Date();
    }

}
