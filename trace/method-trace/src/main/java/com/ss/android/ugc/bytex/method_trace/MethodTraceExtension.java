package com.ss.android.ugc.bytex.method_trace;

import com.ss.android.ugc.bytex.common.BaseExtension;

import java.util.ArrayList;
import java.util.List;

public class MethodTraceExtension extends BaseExtension {

    private List<String> whiteList = new ArrayList<>();


    @Override
    public String getName() {
        return "MethodTracePlugin";
    }

    public List<String> getWhiteList() {
        return whiteList;
    }

    public void setWhiteList(List<String> whiteList) {
        this.whiteList = whiteList;
    }
}
