package sample;

import com.alibaba.fastjson.JSONObject;
import com.okchain.client.impl.OKChainRPCClientImpl;
import com.okchain.transaction.BuildTransaction;
import com.okchain.types.AccountInfo;
import com.okchain.types.RequestPlaceOrderParams;
import com.okchain.types.Token;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendTransaction {
  private static String url_rpc = "http://3.13.150.20:26657";
  private static String privateKey = "29892b64003fc5c8c89dc795a2ae82aa84353bb4352f28707c2ed32aa1011884";

    public static void sendSendTransaction() throws NullPointerException, IOException {
        BuildTransaction.setMode("block");
        OKChainRPCClientImpl client = OKChainRPCClientImpl.getOKChainClient(url_rpc);
        AccountInfo account = client.getAccountInfo(privateKey);
        String to = "okchain1t2cvfv58764q4wdly7qjx5d2z89lewvwq2448n";
        String memo = "send memo";
        List<Token> amountList = new ArrayList<>();
        Token amount = new Token("1.00000000", "tokt");
        amountList.add(amount);
        JSONObject ret = client.sendSendTransaction(account, to, amountList, memo);
        System.out.println(ret);
    }

    public static void sendPlaceOrderTransaction() throws IOException {
        BuildTransaction.setMode("block");
        OKChainRPCClientImpl client = OKChainRPCClientImpl.getOKChainClient(url_rpc);
        AccountInfo account = client.getAccountInfo(privateKey);
        String side = "BUY";
        String product = "tbtc_tusdk";
        String price = "1.10000000";
        String quantity = "1.22000000";
        String memo = "new order memo";
        RequestPlaceOrderParams param = new RequestPlaceOrderParams(price, product, quantity, side);
        JSONObject ret = client.sendPlaceOrderTransaction(account, param, memo);
        System.out.println(ret);
    }

    public static void sendCancelOrderTransaction() throws IOException {
        BuildTransaction.setMode("block");
        OKChainRPCClientImpl client = OKChainRPCClientImpl.getOKChainClient(url_rpc);
        AccountInfo account = client.getAccountInfo(privateKey);
        // u can get order-ID by placing a new order
        String orderId = "ID0003039004-1";
        String memo = "cancel order memo";
        JSONObject ret = client.sendCancelOrderTransaction(account, orderId, memo);
        System.out.println(ret);
    }
  public static void main(String[] args) throws NullPointerException, IOException {
    SendTransaction.sendPlaceOrderTransaction();

  }
}
