import ServiceBase from './ServiceBase';

class KardexServices extends ServiceBase {
    constructor(url) {
        super();
        this.url = url; 
        this.headers = ''; 
        this.setHeaders();
    }
    
    saveProduct = async (productRequestDTO) => {
        console.log('***', productRequestDTO)
        this.setHeaders();
        const requestUrl = `${this.url}/${this.urls.KARDEX_SERVICES_WEB}/${this.urls.REST}/${this.urls.KARDEX}/${this.urls.PRODUCTO}`;
        return await this.postRequest(requestUrl, productRequestDTO);
    };

}

export default KardexServices;