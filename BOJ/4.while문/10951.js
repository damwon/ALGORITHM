const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []
rl.on("line", function(line){
    input.push(line.split(' '))
}).on("close", function(){
    let answer = ''
    var i = 0
    while (input[i] != null) {
        answer = Number(input[i][0]) + Number(input[i][1])
        console.log(answer)
        i++
    }
    process.exit()
})