const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []
rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let T = Number(input[0])
    let nums = []
    for (i=1; i<=T; i++) {
        nums.push(input[i].split(' '))
    }
    for (i=0; i < T; i++) {
        console.log(Number(nums[i][0])+Number(nums[i][1]))
    }
    process.exit()
})