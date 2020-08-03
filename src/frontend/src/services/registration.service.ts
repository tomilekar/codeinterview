import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class RegistrationService {

    url = "http://localhost:8080/rest/registration";

    constructor(private httpClient: HttpClient) {
    }

    registerUser(): void {
        this.httpClient.post(this.url, {}, {observe: 'response'}).subscribe(
            (x) => {
                console.log(x);
            }
        )
    }

}

