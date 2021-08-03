const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []
let cnt = 0

rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let T = Number(input.shift())
    let nums = input[0].split(" ").map((numStr) => Number(numStr))
    nums.unshift(0)
    const DP = new Array(T + 1).fill(1)
    for (let i = 2; i < DP.length; i++) {
        let temp = 0;
        for (let j = 1; j < i; j++) {
            if (nums[j] < nums[i]) {
                if (temp < DP[j] + 1) {
                    temp = DP[j] + 1;
                }
            }

            if (temp != 0) {
                DP[i] = temp;
            }
        }
    }

    console.log(Math.max(...DP))
})
