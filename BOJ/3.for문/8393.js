const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input
rl.on("line", function(line){
    input = Number(line)
}).on("close", function(){
    if (1 <= input && input <= 10000){
        let A = 0
        for (i=1; i<=input; i++) {
            A += i
        }
        console.log(A)
    } else {
        console.log("not valid")
    }
    process.exit()
})