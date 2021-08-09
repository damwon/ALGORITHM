const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let input = []

rl.on("line", function(line){
    input.push(line.split(' '))
}).on("close", function(){
    let T = input.shift()
    let nums = input
    let answer = ''
    nums.sort((a, b) => { 
        if (a[1] === b[1]) {
            return a[0] - b[0] 
        }    
        return a[1] - b[1]    
    })
    .forEach(input => {
        answer += `${input[0]} ${input[1]}\n`
    })
    console.log(answer)
})