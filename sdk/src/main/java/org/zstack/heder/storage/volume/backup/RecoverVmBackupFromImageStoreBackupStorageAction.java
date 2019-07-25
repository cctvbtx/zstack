package org.zstack.heder.storage.volume.backup;

import java.util.HashMap;
import java.util.Map;
import org.zstack.sdk.*;

public class RecoverVmBackupFromImageStoreBackupStorageAction extends AbstractAction {

    private static final HashMap<String, Parameter> parameterMap = new HashMap<>();

    private static final HashMap<String, Parameter> nonAPIParameterMap = new HashMap<>();

    public static class Result {
        public ErrorCode error;
        public org.zstack.heder.storage.volume.backup.RecoverVmBackupFromImageStoreBackupStorageResult value;

        public Result throwExceptionIfError() {
            if (error != null) {
                throw new ApiException(
                    String.format("error[code: %s, description: %s, details: %s]", error.code, error.description, error.details)
                );
            }
            
            return this;
        }
    }

    @Param(required = true, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String groupUuid;

    @Param(required = true, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String srcBackupStorageUuid;

    @Param(required = true, nonempty = false, nullElements = false, emptyString = true, noTrim = false)
    public java.lang.String dstBackupStorageUuid;

    @Param(required = false)
    public java.util.List systemTags;

    @Param(required = false)
    public java.util.List userTags;

    @Param(required = false)
    public String sessionId;

    @Param(required = false)
    public String accessKeyId;

    @Param(required = false)
    public String accessKeySecret;

    @Param(required = false)
    public String requestIp;

    @NonAPIParam
    public long timeout = -1;

    @NonAPIParam
    public long pollingInterval = -1;


    private Result makeResult(ApiResult res) {
        Result ret = new Result();
        if (res.error != null) {
            ret.error = res.error;
            return ret;
        }
        
        org.zstack.heder.storage.volume.backup.RecoverVmBackupFromImageStoreBackupStorageResult value = res.getResult(org.zstack.heder.storage.volume.backup.RecoverVmBackupFromImageStoreBackupStorageResult.class);
        ret.value = value == null ? new org.zstack.heder.storage.volume.backup.RecoverVmBackupFromImageStoreBackupStorageResult() : value; 

        return ret;
    }

    public Result call() {
        ApiResult res = ZSClient.call(this);
        return makeResult(res);
    }

    public void call(final Completion<Result> completion) {
        ZSClient.call(this, new InternalCompletion() {
            @Override
            public void complete(ApiResult res) {
                completion.complete(makeResult(res));
            }
        });
    }

    protected Map<String, Parameter> getParameterMap() {
        return parameterMap;
    }

    protected Map<String, Parameter> getNonAPIParameterMap() {
        return nonAPIParameterMap;
    }

    protected RestInfo getRestInfo() {
        RestInfo info = new RestInfo();
        info.httpMethod = "PUT";
        info.path = "/vm-backups/{groupUuid}/actions";
        info.needSession = true;
        info.needPoll = true;
        info.parameterName = "recoverVmBackupFromImageStoreBackupStorage";
        return info;
    }

}
