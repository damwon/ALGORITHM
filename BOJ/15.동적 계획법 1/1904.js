const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []

rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let N = Number(input[0])
    const dp = Array(N).fill().map((el) => [])
    dp[1] = 1
    dp[2] = 2 
    for (let i = 3; i <= N; i++) {
        dp[i] = (dp[i-1] + dp[i-2])%15746
    }
    console.log(dp[N])
})