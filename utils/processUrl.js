function extractAccessToken(url) {
    const tokenMatch = url.match(/access_token=([^&]+)/);
    console.log("access token is ",tokenMatch?.[1])
    return tokenMatch ? tokenMatch[1] : null;
    
}

export default extractAccessToken;
