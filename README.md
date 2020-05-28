# kbc-online

Game to start at specific time:

- After every 1 minute a new question is broadcasted to every user.
- The user have 10 seconds to choose the right answer. Rest 50 seconds the user waits to receive the correct answer.
- Next question appears after 1 minute. 
- Duration of this game is decided by an input param.
- If the user’s answer is correct, then he is awarded 10 points. 
- If the answer is incorrect, 5 points are deducted from user’s score.
- If the user didn’t choose to answer, no points are added / subtracted from his score.
- Rewards are awarded to users at frequent intervals, once, they surpass the threshold. Each reward comes in form of a coupon code. For eg: Once the user surpasses a score of 45 they should be awarded with coupon code for paytm. 
    - The coupon code can be pre-validated with the vendor, 
    - or a vendor can provide the coupon codes in advance, 
    - or once a coupon code is assigned to a particular user a batch of such code must be send to the vendor at frequent intervals
- The user must be notified by email if they’ve won a reward.
- There should be a dashboard to view user’s score and global / social leaderboard.
