# codingDojang

func coinChange(coins []int, amount int) int {
    dp := make([]int, amount + 1)
    
    for i, _ := range dp {
        dp[i] = amount + 1
    }
    dp[0] = 0
    for i := 1; i <= amount; i++ {
        for c := 0; c < len(coins); c++ {
            if coins[c] <= i {
                dp[i] = Min(dp[i], dp[i - coins[c]] + 1)
            }
        }
    }
    if dp[amount] > amount {
        return -1
    }
    return dp[amount]
}

func Min(a, b int) int {
    if a > b {return b}
    return a
}
