package wjc.redis.remoteservice;

/**
 * Author: 王俊超
 * Date: 2017-12-05 07-22
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class RemoteImpl implements RemoteInterface {

    public RemoteImpl() {
    }

    @Override
    public Long myMethod(Long value) {
        return value * 2;
    }
}