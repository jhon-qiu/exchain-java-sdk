package io.okchain.client;


import com.alibaba.fastjson.JSONObject;
import io.okchain.types.*;

import java.util.List;

public interface OKChainClient {


//    public static OKChainClient getOKChainClient(String backend) {
//        return null;
//    }

    //address api

    public JSONObject getAccountFromNode(String userAddress) throws NullPointerException;

    public AddressInfo createAddressInfo();

    public AddressInfo getAddressInfo(String privateKey) throws NullPointerException;


    //send transaction

    public JSONObject sendSendTransaction(AccountInfo account, String to, List<Token> amount, String memo) throws NullPointerException;


    public JSONObject sendPlaceOrderTransaction(AccountInfo account, RequestPlaceOrderParams parms, String memo) throws NullPointerException;


    public JSONObject sendCancelOrderTransaction(AccountInfo account, String orderId, String memo) throws NullPointerException;


    //query

    public AccountInfo getAccountInfo(String privateKey) throws NullPointerException;

    public BaseModel getAccountALLTokens(String address) throws NullPointerException;

    public BaseModel getAccountToken(String address, String symbol) throws NullPointerException;

    public BaseModel getTokens();

    public BaseModel getToken(String symbol) throws NullPointerException;

    public BaseModel getProducts();

    public BaseModel getDepthBook(String product) throws NullPointerException;

    public BaseModel getCandles(String granularity, String instrumentId, String size) throws NullPointerException;

    public BaseModel getTickers(String count);

    public BaseModel getOrderListOpen(RequestOrderListOpenParams params) throws NullPointerException;

    public BaseModel getOrderListClosed(RequestOrderListClosedParams params) throws NullPointerException;

    public BaseModel getDeals(RequestDealsParams params) throws NullPointerException;

    public BaseModel getTransactions(RequestTransactionsParams params) throws NullPointerException;


}