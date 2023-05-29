package org.montos.groovy.req;

public class GroovyRequest {

    private String script;
    private String method;
    private Object args;

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public Object getArgs() {
        return args;
    }

    public void setArgs(Object args) {
        this.args = args;
    }
}
