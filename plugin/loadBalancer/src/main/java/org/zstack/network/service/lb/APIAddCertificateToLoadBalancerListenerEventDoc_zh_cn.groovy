package org.zstack.network.service.lb

import org.zstack.header.errorcode.ErrorCode
import org.zstack.network.service.lb.LoadBalancerListenerInventory

doc {

	title "负载均衡监听器清单"

	ref {
		name "error"
		path "org.zstack.network.service.lb.APIAddCertificateToLoadBalancerListenerEvent.error"
		desc "错误码，若不为null，则表示操作失败, 操作成功时该字段为null",false
		type "ErrorCode"
		since "2.3"
		clz ErrorCode.class
	}
	ref {
		name "inventory"
		path "org.zstack.network.service.lb.APIAddCertificateToLoadBalancerListenerEvent.inventory"
		desc "null"
		type "LoadBalancerListenerInventory"
		since "2.3"
		clz LoadBalancerListenerInventory.class
	}
}
