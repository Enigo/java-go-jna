package main

import "C"

//export Contains
func Contains(values []string, value string) bool {
	for _, v := range values {
		if v == value {
			return true
		}
	}
	return false

}

func main() {
}
