package io.cosmos.msg;

import io.cosmos.common.EnvInstance;
import io.cosmos.msg.utils.Message;
import io.cosmos.msg.utils.type.MsgAddSharesValue;

public class MsgAddShares extends MsgBase {

    public static void main(String[] args) {
        EnvInstance.setEnv("okq");

        MsgAddShares msg = new MsgAddShares();
        msg.setMsgType("okexchain/staking/MsgAddShares");
        msg.initMnemonic(EnvInstance.getEnv().GetNode0Mnmonic());

        String [] validators = {"okexchainvaloper10q0rk5qnyag7wfvvt7rtphlw589m7frshchly8"};
        Message messages = msg.produceMsg("okexchain10q0rk5qnyag7wfvvt7rtphlw589m7frsku8qc9", validators);


        msg.submit(messages, "6.00000000", "200000", "");
    }

    public Message produceMsg(String delegator, String [] validators) {


        MsgAddSharesValue value = new MsgAddSharesValue();

        System.out.println("this.operAddress:");
        System.out.println(this.operAddress);

        value.setDelAddr(delegator);
        value.setValAddrs(validators);

        Message<MsgAddSharesValue> msg = new Message<>();
        msg.setType(msgType);
        msg.setValue(value);
        return msg;
    }
}