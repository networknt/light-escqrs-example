package com.networknt.eventuate.account.command.customer;


import com.networknt.eventuate.account.common.model.customer.ToAccountInfo;

/**
 * Created by Main on 08.02.2016.
 */
public class AddToAccountCommand implements CustomerCommand {

  private ToAccountInfo toAccountInfo;

  public AddToAccountCommand(ToAccountInfo toAccountInfo) {
    this.toAccountInfo = toAccountInfo;
  }

  public ToAccountInfo getToAccountInfo() {
    return toAccountInfo;
  }
}
