const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []

rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let T = input.shift()
    let testCase = input.map((numStr) => Number(numStr))
    const fibo = Array.from({ length: 41 })
    fibo[0] = 0
    fibo[1] = 1 
    for (let i = 2; i <= 40; i++) { 
        fibo[i] = fibo[i - 1] + fibo[i - 2]
    } 
    fibo.unshift(1)
    const log = []
    for (let i = 0; i < T; i++) {
        const n = +testCase[i]
        log.push([fibo[n], fibo[n + 1]])
    }
    console.log(log.map((el) => el.join(" ")).join("\n"))
})
//메모이제이션