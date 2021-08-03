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
    selectionSort(nums,T)
    for (i=0; i<T; i++) {
        console.log(nums[i])
    }
})

function selectionSort(arr,N) {
    for (i=0; i<N-1; i++) {
        let min = i
        for (j=i+1; j<N; j++) {
            if (arr[j] < arr[min]) min=j

        }
        [arr[i], arr[min]] = [arr[min], arr[i]]
    }
}