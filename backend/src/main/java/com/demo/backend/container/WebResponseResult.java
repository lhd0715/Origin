package com.demo.backend.container;

public class WebResponseResult<T extends WebResponseForm> {
	private T responseForm;

	public T getResponseForm() {
        return responseForm;
    }

    public void setResponseForm(T responseForm) {
        this.responseForm = responseForm;
    }
}
