const readline = require('readline')

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []
rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let num = Number(input)
    let sum
    let i = 0
    while (true) {
      i++
      sum = Math.floor(num / 10) + num % 10 // 1의자리수는 %10, 10의자리수는 /10 내림
      num = (num % 10) * 10 + sum % 10
      if(Number(input) === num) break 
    }
    console.log(i)
    process.exit()
})