# payment through confirmation

This project (demo) implements an application that starts when a user submits
an order (i.e. they've filled their shopping cart and now want to check out)
and it performs the following steps:

1. process the payment getting back a payment confirmation number
2. record that payment in a ledger
3. send an email to the user confirming the order
4. fulfill the order getting back a tracking number
5. send an email to the user confirming 

The only step that is synchronous is the payment processing - no other steps
can proceed unless that one is successful - but all other steps can finish 
asynchronously. They can't never happen, but they can happen eventually
(within some reasonable timeframe). The flow we implement is as follows:

```
   ---> 2 --------
   |              |
1 -+--> 3 --------+---> Finish
   |              |
   ---> 4 --> 5 --

```

The activities make calls out to third party services (which for the demo, will
generally go to [mocked services](https://github.com/cdavisafc/thirdpartyservicemocks))