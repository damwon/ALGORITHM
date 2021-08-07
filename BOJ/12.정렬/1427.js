const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let input = []

rl.on("line", function(line){
    input = line.split('')
}).on("close", function(){
    let nums = input
    nums.sort((a, b) => b - a)
    console.log(nums.join(''))
})