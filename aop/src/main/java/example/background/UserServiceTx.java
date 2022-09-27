package example.background;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserServiceTx  {

//    private final UserService userService;
//    private final PlatformTransactionManager transactionManager;
//
//    public void add(User user) {
//        this.userService.add(user);
//    }
//
//
//    public void upgradeInternal() {
//        TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
//
//        try {
//            userService.upgrade();
//            this.transactionManager.commit(status);
//        } catch (RuntimeException e) {
//            this.transactionManager.rollback(status);
//            throw e;
//        }
//    }
}
