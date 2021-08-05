const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let input = []

rl.on("line", function(line){
    input.push(Number(line))
}).on("close", function(){
    let T = input.shift()
    let nums = input
    nums.sort((a, b) => a - b)
    console.log(nums.join('\n'))
})