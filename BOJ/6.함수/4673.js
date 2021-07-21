function d(n) {
  let num = n
  let add = 0
  for (let i = 0; i < String(n).length; i++) {
      add += num % 10
      num = Math.floor(num / 10)
  }
  return n + add
}

let self = Array(10001).fill(true)

for (let i = 0; i <= 10000; i++) {
  self[d(i)] = false;
}

for (let i = 0; i <= 10000; i++) {
  if (self[i]) {
      console.log(i)
  }
}